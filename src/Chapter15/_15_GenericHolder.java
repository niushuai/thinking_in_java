package Chapter15;

public class _15_GenericHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        _15_GenericHolder<String> holder = new _15_GenericHolder<String>();
        holder.set("Item");
        // 这里没有转型了，但是我们知道传递给 set()的值在编译期还是会接受检查
        String s = holder.get();
    }
}
