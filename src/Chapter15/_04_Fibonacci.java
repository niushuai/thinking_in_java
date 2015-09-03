package Chapter15;

/**
 * 从这个例子可以看到泛型的一个局限性：无视使用基本类型作为类型参数。
 * 
 * 但是 Java SE5具备 autoboxing，所以也可以方便的进行转换。
 * 
 */
public class _04_Fibonacci implements Generator<Integer> {

    private int count = 0;

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    public static void main(String[] args) {
        _04_Fibonacci fib = new _04_Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fib.next());
        }
    }

}
