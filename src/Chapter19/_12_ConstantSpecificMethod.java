package Chapter19;

/**
 * 你问我这像什么？
 * 
 * 这难道不像枚举的多态吗？enum实例似乎被当做超类使用，然而，enum实例与类的相似之处也仅限于此了。。。且听下回分解！
 * 
 * @author niushuai02
 * 
 */
public enum _12_ConstantSpecificMethod {

    FORMAT1 {
        @Override
        void different() {
            System.out.println("format1");
        }
    },
    FORMAT2 {
        @Override
        void different() {
            System.out.println("format2");
        }
    };

    abstract void different();

    public static void main(String[] args) {
        for (_12_ConstantSpecificMethod csm : values()) {
            csm.different();
        }
    }
}
