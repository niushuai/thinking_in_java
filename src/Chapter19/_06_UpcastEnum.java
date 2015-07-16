package Chapter19;

enum Search {
    HITHER, YON
}

/**
 * values()是编译器加上的 static 方法，而 Enum 类是木有的。所以<code>e.values()</code>编译错误
 * 
 * 但是 Class 类有一个getEnumConstants()方法可以获取枚举类的所有实例。<br>
 * 因为这个方法在 Class 类中，所以全部类都可以使用， 只是非枚举类使用时会返回一个 NULL
 */
public class _06_UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum e = Search.HITHER; // Upcast
        // e.values();
        for (Enum en : Search.class.getEnumConstants()) {
            System.out.println(en);
        }

        System.out.println(Integer.class.getEnumConstants() == null);
        // 因为返回的是 null，所以就是空指针异常了
        for (Object en : Integer.class.getEnumConstants()) {
            System.out.println(en);
        }
    }
}