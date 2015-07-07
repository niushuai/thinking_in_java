package Chapter21;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

class Leader implements Comparable {
    private String name;
    private int degree;

    public Leader(String name, int degree) {
        this.name = name;
        this.degree = degree;
    }

    @Override
    public int compareTo(Object o) {
        Leader leader = (Leader) o;
        return leader.degree - this.degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

}

public class WhoGoFirst {

    // 通过随机数给领导分级别
    private static PriorityBlockingQueue<Leader> leaders = new PriorityBlockingQueue<Leader>();

    public static void watchFilm(Leader leader) {
        leaders.add(leader);
    }

    public static void goFirst(PriorityBlockingQueue<Leader> leaders) {
        try {
            while (!leaders.isEmpty()) {
                Leader leader = leaders.take();
                System.out.println("级别： " + leader.getDegree() + "的 " + leader.getName() + " 正在撤离...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            watchFilm(new Leader("leader " + i, random.nextInt(10)));
        }

        System.out.println("所有领导已经就坐，开始播放电影：速度与激情7...");

        System.out.println("着火了！！！");

        goFirst(leaders);

    }
}/*output:
所有领导已经就坐，开始播放电影：速度与激情7...
着火了！！！
级别： 8的 leader 3 正在撤离...
级别： 7的 leader 8 正在撤离...
级别： 6的 leader 4 正在撤离...
级别： 6的 leader 9 正在撤离...
级别： 6的 leader 2 正在撤离...
级别： 5的 leader 5 正在撤离...
级别： 4的 leader 6 正在撤离...
级别： 4的 leader 7 正在撤离...
级别： 2的 leader 10 正在撤离...
级别： 0的 leader 1 正在撤离...
*/
