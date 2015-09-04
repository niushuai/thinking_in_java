package Chapter15;

import java.util.Iterator;

public class _05_IterableFibonacci extends _04_Fibonacci implements Iterable<Integer> {
    private int n;

    // 要遍历count 次
    public _05_IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return _05_IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new _05_IterableFibonacci(18)) {
            System.out.println(i + " ");
        }
    }
}
