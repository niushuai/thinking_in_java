package Chapter21;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 第一步：Chassis 创建一个 new MyCar，然后装底盘<br>
 * 第二步：Assembler 装配，从 RobotPool 中取得机器人资源，组装引擎、动力系统、轮胎<br>
 * 第三步：组装完成后会有一个记录系统，并将完成的车辆放入 finishingQueue<br>
 */
class MyCar {
    private final int id;
    private boolean engine;
    private boolean driveTrain;
    private boolean wheels;

    public MyCar(int id) {
        this.id = id;
    }

    public MyCar() {
        id = -1;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [" + " engine: " + engine + " driveTrain: " + driveTrain + " wheels: " + wheels + " ]";
    }
}

// 模拟工厂的流水线
class CarQueue extends LinkedBlockingQueue<MyCar> {
    private static final long serialVersionUID = -8022590210916666885L;
}

// 底盘环节
class ChassisBuilder implements Runnable {
    // 底盘的 carQueue 是一辆车的第一个入口
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 创建新车 & 安装底盘
                MyCar myCar = new MyCar(counter++);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(myCar + "底盘已经搞定，其余部件开始装配：");
                carQueue.put(myCar);
            }
        } catch (InterruptedException e) {
            System.out.println("底盘制造被终止！");
        }
        System.out.println("底盘装配线关闭...");
    }
}

// 组装引擎、动力系统、轮胎环节
class Assembler implements Runnable {
    // 底盘之后的第二道工序
    private CarQueue chassisQueue;
    private CarQueue finishingQueue;
    private MyCar myCar;
    // 不用 CountDownLatch 是因为要复用
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }

    public MyCar car() {
        return myCar;
    }

    public CyclicBarrier barrier() {
        return cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 阻塞直到底盘装配线传来待组装的车
                myCar = chassisQueue.take();

                // 使用机器人装配
                robotPool.consume(EngineRobot.class, this);
                robotPool.consume(DriveTrainRobot.class, this);
                robotPool.consume(WheelRobot.class, this);

                // 第四个 barrier，表示车组装完成
                cyclicBarrier.await();
                finishingQueue.put(myCar);
            }
        } catch (InterruptedException e) {
            System.out.println("装配引擎、动力系统、轮胎被终止！");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("组装装配线关闭...");
    }
}

// 通报系统
class Reporter implements Runnable {
    private CarQueue finishingQueue;

    public Reporter(CarQueue finishingQueue) {
        this.finishingQueue = finishingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(finishingQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("通报系统被终止！");
        }
        System.out.println("通报系统关闭...");
    }
}

// 抽象组装过程中的三个机器人
abstract class Robot implements Runnable {
    private RobotPool robotPool;
    protected Assembler assembler;
    private boolean isWorking = false;

    public Robot(RobotPool robotPool) {
        this.robotPool = robotPool;
    }

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    // 开始干活
    public synchronized void engage() {
        isWorking = true;
        notifyAll();
    }

    abstract protected void performService();

    @Override
    public void run() {
        try {
            // wait until needed
            powerDown();
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await();
                // 已经做完了
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("机器人自动装配被终止！");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + "关闭...");
    }

    // 消除状态，停止工作。直到有可用的机器人
    private synchronized void powerDown() throws InterruptedException {
        isWorking = false;
        assembler = null;
        robotPool.releaser(this);
        while (isWorking == false) {
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

// 安装引擎机器人
class EngineRobot extends Robot {
    public EngineRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " 安装引擎...");
        assembler.car().addEngine();
    }
}

// 安装动力系统机器人
class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " 安装动力系统...");
        assembler.car().addDriveTrain();
    }
}

// 安装轮胎机器人
class WheelRobot extends Robot {
    public WheelRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " 安装轮胎...");
        assembler.car().addWheels();
    }
}

// 机器人池
class RobotPool {
    private Set<Robot> pool = new HashSet<Robot>();

    // 使用完毕的机器人重新放入资源池，然后通知等待该机器人的任务
    public synchronized void produce(Robot robot) {
        pool.add(robot);
        notifyAll();
    }

    // 机器人消费者
    public synchronized void consume(Class<? extends Robot> robotType, Assembler assembler) throws InterruptedException {
        for (Robot robot : pool) {
            if (robot.getClass().equals(robotType)) {
                pool.remove(robot);
                robot.assignAssembler(assembler);
                robot.engage();
                return;
            }
        }
        wait();
        consume(robotType, assembler);
    }

    // 释放资源，本质就是重新加入到机器人池
    public synchronized void releaser(Robot robot) {
        produce(robot);
    }
}

public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 初始化机器人池，每个类型只有一个机器人，所以是临界资源
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));

        /**
         * 生产线正式启动。<br>
         * 故意把底盘装配（第一个环节）放在最后一个启动，反正 Assembler 会自动阻塞
         */
        CarQueue chassisQueue = new CarQueue();
        CarQueue finishingQueue = new CarQueue();
        exec.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
        exec.execute(new Reporter(finishingQueue));
        exec.execute(new ChassisBuilder(chassisQueue));

        // 模拟程序在7秒后自动结束
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
