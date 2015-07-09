package Chapter19;

/**
 * 感觉 enum 和类基本一样啊，这不就普普通通的重载吗。。。只不过对于 NUL和 BOLT 而言，f()就是常量。
 * 
 * @author niushuai02
 *
 */
public enum _15_OverrideConstantSpecific {
    NUT, BOLT, WASHER {
        void f() {
            System.out.println("Overridden method");
        }
    };

    void f() {
        System.out.println("default method");
    }

    public static void main(String[] args) {
        for (_15_OverrideConstantSpecific ocs : values()) {
            System.out.print(ocs + " ");
            ocs.f();
        }
    }
}
