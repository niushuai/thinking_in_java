package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

import java.util.Random;

/**
 * 工具类，用于随机产生枚举的 enum 实例，测试时候使用
 */
class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length - 1)];
    }
}

/**
 * 两个类型之间的比较
 */
interface Competitor<T extends Competitor<T>> {
    _18_Outcome compete(T competitor);
}

/**
 * 工具类，模拟比赛
 */
class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}

/**
 * 用查表的方式来玩游戏
 */
public enum _20_RoShamBo2 implements Competitor<_20_RoShamBo2> {
    // paper
    PAPER(DRAW, LOSE, WIN),
    // scissors
    SCISSORS(WIN, DRAW, LOSE),
    // rock
    ROCK(LOSE, WIN, DRAW);

    private _18_Outcome vPAPER, vSCISSORS, vROCK;

    _20_RoShamBo2(_18_Outcome paper, _18_Outcome scissors, _18_Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    /**
     * 查表操作
     */
    @Override
    public _18_Outcome compete(_20_RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    // 用_20_RoShamBo2这个枚举，玩20次游戏
    public static void main(String[] args) {
        RoShamBo.play(_20_RoShamBo2.class, 20);
    }
}
