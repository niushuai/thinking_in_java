package Chapter19;

enum Signal {
    RED, GREEN, YELLOW
}

/**
 * 1. switch 的括号中只能放 int 类型的，所以能放 byte/char/short/int/枚举（本质调用了 ordinal()方法）<br>
 * 2. 但是 JDK 1.7又增加了 String<br>
 * 3. 不能放 double/Long 之类的，因为向上转型是安全的，向下转型是不安全的
 * 
 * @author niushuai02
 * 
 */
public class _04_SwitchEnum {
    public static void main(String[] args) {
        Signal color = Signal.RED;

        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            default:
                break;
        }

        System.out.println(color);
        System.out.println(Signal.RED.getClass());
    }

}
