package Chapter15;

import java.util.Iterator;
import java.util.Random;

interface Generator<T> {
    T next();
}

class Coffee {
}

class Kabuqinuo extends Coffee {
    @Override
    public String toString() {
        return "Kabuqinuo";
    }
}

class Xingbingle extends Coffee {
    @Override
    public String toString() {
        return "Xingbingle";
    }
}

class Mocha extends Coffee {
    @Override
    public String toString() {
        return "Mocha";
    }
}

public class _03_CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private static Random random = new Random(47);
    private int size = 0;
    private Class[] type = { Kabuqinuo.class, Xingbingle.class, Mocha.class };

    public _03_CoffeeGenerator() {

    }

    public _03_CoffeeGenerator(int size) {
        this.size = size;
    }

    /**
     * 实现Iterator
     */
    class CoffeeIterator implements Iterator<Coffee> {
        private int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return _03_CoffeeGenerator.this.next();
        }

    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) type[random.nextInt(type.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        _03_CoffeeGenerator gen = new _03_CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        System.out.println("================");

        for (Coffee c : new _03_CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }

}
