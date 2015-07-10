package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

import java.util.Random;

interface Item {
    _18_Outcome compete(Item it);

    _18_Outcome eval(Paper p);

    _18_Outcome eval(Scissors s);

    _18_Outcome eval(Rock r);
}

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
        return "Papre";
    }

}

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
 * 第一个版本的石头剪刀布
 * 
 * @author niushuai02
 * 
 */
public class Roshambo1 {
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

    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
