package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

import java.util.Random;

/**
 * 多路分发的接口
 * 
 * @author niushuai02
 *
 */
interface Item {
    _18_Outcome compete(Item it);

    _18_Outcome eval(Paper p);

    _18_Outcome eval(Scissors s);

    _18_Outcome eval(Rock r);
}

// 布
class Paper implements Item {

    @Override
    public _18_Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public _18_Outcome eval(Paper p) {
        return DRAW;
    }

    @Override
    public _18_Outcome eval(Scissors s) {
        return WIN;
    }

    @Override
    public _18_Outcome eval(Rock r) {
        return LOSE;
    }

    public String toString() {
        return "Paper";
    }

}

// 剪刀
class Scissors implements Item {

    @Override
    public _18_Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public _18_Outcome eval(Paper p) {
        return LOSE;
    }

    @Override
    public _18_Outcome eval(Scissors s) {
        return DRAW;
    }

    @Override
    public _18_Outcome eval(Rock r) {
        return WIN;
    }

    public String toString() {
        return "Scissors";
    }

}

// 锤子
class Rock implements Item {

    @Override
    public _18_Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public _18_Outcome eval(Paper p) {
        return WIN;
    }

    @Override
    public _18_Outcome eval(Scissors s) {
        return LOSE;
    }

    @Override
    public _18_Outcome eval(Rock r) {
        return DRAW;
    }

    public String toString() {
        return "ROCK";
    }

}

/**
 * 第一个版本的石头剪刀布。所谓的多路分发，就是一次不能确定多个类型的情况，就多次调用，<br>
 * 保证每次调用都能确定一个类型。到头的话，就能确定全部的类型了。
 * 
 * @author niushuai02
 * 
 */
public class _19_Roshambo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    /**
     * 调用 match 的时候，a 的类型已经确定，
     * 
     * @param a
     * @param b
     */
    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));

    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
