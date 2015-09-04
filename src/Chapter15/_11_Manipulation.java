package Chapter15;

/**
 * 因为擦除效应，Java 编译器无法将manipulate()在 obj 上调用f()这个需求映射到 HasF 有f()这一事实上
 * 
 * 解决办法是协助泛型类，给定泛型类的边界，这样编译器才不会完全不知所措。
 * 
 * @author niushuai
 *
 * @param <T>
 */

class HasF {
    public void f() {
        System.out.println("HasF:f()");
    }
}

class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        // 找到 f()这个方法
        // obj.f();
    }
}

// 指定了擦除边界，编译器最后知道的就是，这个没有泛型，就是 HasF
class ManipulatorNew<T extends HasF> {
    private T obj;

    public ManipulatorNew(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

public class _11_Manipulation<T> {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
