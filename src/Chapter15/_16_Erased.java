package Chapter15;

// 无法编译，因为 T 的类型被擦除了。
class Erased<T> {
    public static void f(Object obj) {
        // if(obj instanceof T) {
        //
        // }
        //
        // T var = new T();
        // T[] t = new T[100]();
    }
}

class Building {

}

class House extends Building {

}

// 显式把 class 传入，其实和擦除也没有毛线关系啊。。。
public class _16_Erased<T> {

    private Class<T> type;

    public _16_Erased(Class<T> type) {
        this.type = type;
    }

    public boolean f(Object obj) {
        return type.isInstance(obj);
    }

    public static void main(String[] args) {
        _16_Erased<Building> ctt1 = new _16_Erased<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        System.out.println("============");

        _16_Erased<House> ctt2 = new _16_Erased<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
