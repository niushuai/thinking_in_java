package Chapter15;

public class _20_ArrayOfGeneric {
    static final int SIZE = 100;
    // gia 在创建的时候就确定了类型是 Integer
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // 编译错误，ClassCastException
        // gia = (Generic<Integer>[]) new Object[SIZE];
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();

        // 下面2个在编译期就提示错误
        // gia[1] = new Object();
        // gia[2] = new Generic<Double>();
    }
}
