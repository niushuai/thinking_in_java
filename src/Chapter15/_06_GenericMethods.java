package Chapter15;

/**
 * 最最简单的泛型方法
 * 
 * @author niushuai
 *
 */
public class _06_GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        _06_GenericMethods generic = new _06_GenericMethods();

        generic.f(1);
        generic.f(1.2);
        generic.f("String");
        generic.f('a');
        generic.f(123L);
        generic.f(1.3f);

    }
}
