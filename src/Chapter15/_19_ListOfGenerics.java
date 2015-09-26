package Chapter15;

import java.util.ArrayList;
import java.util.List;

class Generic<T> {
}

/**
 * 可以创建泛型数组（ArrayList 本质就是实现 List 接口，底层使用数组保存所有元素). 但是无法创建{@code Generic<T>}的泛型数组
 */
public class _19_ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
