package Chapter15;

/**
 * 这个的改进之处是在里面使用的就是 Object[]，而不是在创建时就立即将其转型为 T[],<br>
 * 立即转型存在的问题是：编译期该数组的实际类型将丢失，编译器可能会错过某些潜在的错误检查<br>
 * 所以正确是在集合内部使用 Object[]，当你使用数组元素时，才将其转型。
 * <p>
 * 书上的解释是：在内部将 Array 当做 Object[]而不是 T[]的优势是，我们不太可能忘记这个数组<br>
 * 的运行时类型，从而意外地引入缺陷（尽管大多数也可能是所有这类缺陷都可以在运行时快速探测到。
 * <p>
 * 我想说，这翻译的是个鬼！！！！！！！！！
 *
 */
public class _22_GenericArray2<T> {
    private Object[] array;

    public _22_GenericArray2(int size) {
        array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        _22_GenericArray2<Integer> gai = new _22_GenericArray2<Integer>(10);

        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();

        // 这里还是会抛出转型异常，gai被擦除后是无论如何都转不成 Integer[]的
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
