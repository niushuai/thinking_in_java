//package Chapter21;
//
//import java.util.Iterator;
//import java.util.Random;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.DelayQueue;
//import java.util.concurrent.Delayed;
//import java.util.concurrent.TimeUnit;
//
//public class Exam {
//    // 模拟每个学生的交卷时间
//    private static Random random = new Random();
//
//    public static void main(String[] args) throws InterruptedException {
//        int studentNumber = 20;
//        // 当所有学生完成之后，就可以宣布考试结束了
//        CountDownLatch countDownLatch = new CountDownLatch(studentNumber + 1);
//        // 按照学生的交卷时间管理
//        DelayQueue<Student> students = new DelayQueue<Student>();
//        for (int i = 0; i < studentNumber; i++) {
//            students.put(new Student("student" + (i + 1), 30 + random.nextInt(120), countDownLatch));
//        }
//
//        // 老师线程作用就是收取学生的试卷，本来需要同步锁机制。但是因为 DelayQueue 是一个使用了
//        // PriorityQueue 的 BlockingQueue，且使用 Delayed 接口的 getDelay()的时间作为比较的优先级
//        // 所以，BlockingQueue 就隐藏了锁操作。只需要专注业务逻辑。
//        Thread teacherThread = new Thread(new Teacher(students));
//
//        // 这里很有趣。思考一下，为什么加入一个考试结束控制器？
//        students.put(new EndExam(students, 120, countDownLatch, teacherThread));
//
//        teacherThread.start();
//        countDownLatch.await();
//        System.out.println("考试时间到，全部交卷！");
//    }
//}
//
//class Student implements Runnable, Delayed {
//
//    private final String name;
//    private final long workTime;
//    private final long submitTime;
//    private boolean isForce = false;
//    private final CountDownLatch countDownLatch;
//
//    public Student(String name, long workTime, CountDownLatch countDownLatch) {
//        this.name = name;
//        this.workTime = workTime;
//        this.submitTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.NANOSECONDS) + System.nanoTime();
//        this.countDownLatch = countDownLatch;
//    }
//
//    @Override
//    public int compareTo(Delayed o) {
//        if (o == null || !(o instanceof Student))
//            return 1;
//        if (o == this)
//            return 0;
//        Student s = (Student) o;
//        return (int) (this.workTime - s.workTime);
//    }
//
//    @Override
//    public long getDelay(TimeUnit unit) {
//        return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
//    }
//
//    @Override
//    public void run() {
//        if (isForce) {
//            System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 120分钟");
//        } else {
//            System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 " + workTime + " 分钟");
//        }
//        // 完成之后就可以让 countDownLatch 减一
//        countDownLatch.countDown();
//    }
//
//    public boolean isForce() {
//        return isForce;
//    }
//
//    public void setForce(boolean isForce) {
//        this.isForce = isForce;
//    }
//}
//
//class EndExam extends Student {
//
//    private final DelayQueue<Student> students;
//    private final CountDownLatch countDownLatch;
//    private final Thread teacherThread;
//
//    public EndExam(DelayQueue<Student> students, long workTime, CountDownLatch countDownLatch, Thread teacherThread) {
//        super("强制收卷", workTime, countDownLatch);
//        this.students = students;
//        this.countDownLatch = countDownLatch;
//        this.teacherThread = teacherThread;
//    }
//
//    @Override
//    public void run() {
//
//        teacherThread.interrupt();
//        System.out.println("考试结束！下面是强制收卷子");
//        Student tmpStudent = null;
//        for (Iterator<Student> iterator2 = students.iterator(); iterator2.hasNext();) {
//            tmpStudent = iterator2.next();
//            tmpStudent.setForce(true);
//            tmpStudent.run();
//        }
//        countDownLatch.countDown();
//    }
//
//}
//
//class Teacher implements Runnable {
//
//    private final DelayQueue<Student> students;
//
//    public Teacher(DelayQueue<Student> students) {
//        this.students = students;
//    }
//
//    @Override
//    public void run() {
//        try {
//            System.out.println("考试开始...");
//            while (!Thread.interrupted()) {
//                students.take().run();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("助手开始强制收卷子..");
//        }
//    }
//
// }
