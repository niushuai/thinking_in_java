package Chapter19;

/**
 * 1. ordinal()返回每个enum实例在声明时的次序，从0开始。<br>
 * 2. 可以使用==比较enum实例，因为每个enum实例都继承自Enum类，会提供equals()和hashCode()方法<br>
 * 3. Enum类实现了Comparable和Serialiazble接口<br>
 * 4. 调用getDeclaringClass()就能知道enum实例所属的enum类<br>
 * 
 * @author niushuai02
 * 
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class _01_EnumClass {
    public static void main(String[] args) {
        // 可以使用 values()方法遍历枚举，顺序为 enum 实例声明的顺序
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " 在枚举类中次序： " + s.ordinal());
            // Enum 类实现了 Comparable 和 Serializable 接口
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println(s.toString());
            System.out.println(s);
            System.out.println("===============");
        }

        for (String s : "HANGING CRAWLING GROUND HHHH".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
