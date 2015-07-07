package Chapter07;

class Insect {
    private static int num = init("First");
    private String name;

    public Insect(String name) {
        this.name = name;
        System.out.println("the insect's name is :" + this.name);
    }

    public static int init(String string) {
        System.out.println(string);
        return 2014;
    }
}

public class Bettle extends Insect {
    public Bettle(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Bettle bettle = new Bettle("niu");
    }
}
