package Chapter15;

public class _21_GenericArray<T> {
    // 因为不能使用 T[] array = new T[size]，所以用 Object 来创建
    private T[] array;

    public _21_GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        _21_GenericArray<Integer> gai = new _21_GenericArray<Integer>(10);

        // 会有一个类型转换异常,因为运行时 gai 已经是 Object[]了，不能转成 Integer
        // Integer[] ia = gai.rep();

        Object[] ia = gai.rep();
    }
}
