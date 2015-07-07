package Chapter21;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class Teacher implements Runnable {

    private DelayQueue<Student> students = null;

    public Teacher(DelayQueue<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        try {
            // 老师只负责看场子，考试结束后也是 Assistant 继续做事
            while (!Thread.interrupted()) {
                students.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Student implements Runnable, Delayed {

    private String name;
    private int workTime;
    private int submitTime;
    private boolean timeOut = false;
    private CountDownLatch countDownLatch;

    public Student(String name, int workTime, CountDownLatch countDownLatch) {
        this.name = name;
        this.workTime = workTime;
        this.submitTime = (int) TimeUnit.NANOSECONDS.convert(System.nanoTime() + workTime, TimeUnit.NANOSECONDS);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (timeOut == false) {
            System.out.println(name + " 完成考试...期望用时：" + workTime + ", 实际用时：" + workTime);
        } else {
            System.out.println(name + " 未完成考试...期望用时：" + workTime + ", 实际用时：120");
        }
        countDownLatch.countDown();
    }

    @Override
    public int compareTo(Delayed o) {
        Student that = (Student) o;
        return this.workTime - that.workTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public void setTimeOut(boolean timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return name + " 期望用时： " + workTime + "\n";
    }
}

// 助手，其实是考试结束的哨兵
class Assistant extends Student {

    private CountDownLatch countDownLatch = null;
    private Thread teacherThread = null;
    private DelayQueue<Student> students = null;

    public Assistant(String name, int workTime, CountDownLatch countDownLatch, Thread teacherThread,
            DelayQueue<Student> students) {
        super(name, workTime, countDownLatch);
        this.countDownLatch = countDownLatch;
        this.teacherThread = teacherThread;
        this.students = students;
    }

    @Override
    public void run() {
        System.out.println("\n考试时间到！！！！请大家放下纸笔，立即交卷！！！这不是在演习，这不是在演习！！！\n");
        // 告诉老师，时间到了，是我的 show time
        teacherThread.interrupt();
        /**
         * 将120分钟还没有完成的同学的试卷强制收上来.<br>
         * 
         * 问：但是这里为什么用的是 students.iterator()？这样不是重头遍历了吗？<br>
         * 答：DelayQueue<Student>前面的元素已经获取并且删除了，去看文档： <br>
         * 1. peek()不会删除头元素，如果队为空，返回 nulll<br>
         * 2. poll()会删除头元素，但是如果获取不到到期的元素，就会立马返回一个 null<br>
         * 3. take()会删除头元素，如果获取不到到期的元素，就会阻塞<br>
         */
        Student tempStudent = null;
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            tempStudent = iterator.next();
            tempStudent.setTimeOut(true);
            tempStudent.run();
        }

        // 表示收卷子完成
        countDownLatch.countDown();

    }
}

public class MyExam {
    private static final int MIN_EXAM_TIME = 30;
    private static final int STUDENT_NUM = 20;
    private static Random random = new Random(47);

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Student> students = new DelayQueue<Student>();
        CountDownLatch countDownLatch = new CountDownLatch(STUDENT_NUM + 1);
        for (int i = 0; i < STUDENT_NUM; i++) {
            students.add(new Student("student " + (i + 1), MIN_EXAM_TIME + random.nextInt(120), countDownLatch));
        }

        // DEBUG
        // System.out.println(Arrays.asList(students));

        // 老师线程作用就是收取学生的试卷，本来需要同步锁机制。但是因为 DelayQueue 是一个使用
        // PriorityQueue 实现的 BlockingQueue，且使用 Delayed 接口的 getDelay()的时间作为比较的优先级
        // 所以，BlockingQueue 就隐藏了锁操作。
        Thread teacherThread = new Thread(new Teacher(students));

        students.add(new Assistant("强制收卷子...", 120, countDownLatch, teacherThread, students));

        teacherThread.start();
        countDownLatch.await();
        // 卷子全部收齐，考试结束
        System.out.println("考试结束！！！！！");
    }
}
