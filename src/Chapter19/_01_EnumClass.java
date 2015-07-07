package Chapter19;

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class _01_EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " 在枚举类中次序： " + s.ordinal());
            // Enum 类实现了 Comparable 和 Serializable 接口
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("===============");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
