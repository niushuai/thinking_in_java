package Chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * create 竟然没有任何警告，虽然我们知道 {@code new ArrayList<T>}的{@code <T>}被擦除了
 * <p>
 * 
 * 在 运行时，这个类的内部没有任何{@code <T>},但是也不能变为{@code new ArrayList()}，编译器会用的啊！！！<br>
 * 编译器在编译期确保放置到 result 的对象具有 T 类型，所以即使擦除在方法或类内部有关实际类型的信息，<br>
 * 编译器在编译期也能确保在方法或类中使用的类型的内部一致性。
 * <p>
 * 
 * 那么，在运行时没有了类型信息，就需要确定边界：即对象进入和离开方法的地点。这些正是编译器在编译期提前做好的<br>
 * 编译器会在编译期执行类型检查并插入转型代码的地点。
 */
public class _14_FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>(n);
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        _14_FilledListMaker<String> stringMaker = new _14_FilledListMaker<String>();
        List<String> stringList = stringMaker.create("Hello", 9);

        System.out.println(stringList);
    }
}
