package Chapter19;

/**
 * enum竟然实现接口，233。因为enum继承自Enum，而Java是简单的单继承。只能implements了
 * 
 * @author niushuai02
 * 
 */
interface PlayGame {
    void showGameInfo();
}

enum Game implements PlayGame {
    CARS("极品飞车"), BASKETBALL("NBA"), OTHER("其他");

    private String des;

    private Game(String des) {
        this.des = des;
    }

    @Override
    public void showGameInfo() {
        System.out.println(des);
    }
}

public class _07_EnumImplementation {
    public static void main(String[] args) {
        PlayGame p = Game.CARS;
        p.showGameInfo();

        p = Game.BASKETBALL;
        p.showGameInfo();

        p = Game.OTHER;
        p.showGameInfo();
    }
}
