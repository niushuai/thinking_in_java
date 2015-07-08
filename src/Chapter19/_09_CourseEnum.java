package Chapter19;

/**
 * enum嵌套，本质没有这样的语法。只是用构造函数实现以下而已
 * 
 * @author niushuai02
 * 
 */
interface InnerEnum {
    enum Hi implements InnerEnum {
        HHH, BBBBBB;
    }

    enum Hello implements InnerEnum {
        FDSFDS, FDSAFDSFDSA;
    }
}

public enum _09_CourseEnum {
    SayHi(InnerEnum.Hi.class), SayHello(InnerEnum.Hello.class);

    private InnerEnum[] val;

    private _09_CourseEnum(Class<? extends InnerEnum> val) {
        this.val = val.getEnumConstants();
    }

    public InnerEnum show() {
        return val[1];
    }

    public static void main(String[] args) {
        System.out.println(_09_CourseEnum.SayHi.show());
    }
}
