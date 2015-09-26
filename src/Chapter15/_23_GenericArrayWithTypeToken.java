package Chapter15;

import java.lang.reflect.Array;

public class _23_GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public _23_GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
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
        _23_GenericArrayWithTypeToken<Integer> gai = new _23_GenericArrayWithTypeToken<Integer>(Integer.class, 10);
        // 使用类型标签以后终于可以了，看到这个才是王道。泛型完全不行啊，太垃圾了！！！！
        Integer[] ia = gai.rep();
    }
}
