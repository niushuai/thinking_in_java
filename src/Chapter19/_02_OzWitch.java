package Chapter19;

/**
 * 如果想在枚举类中自己定义方法时:<br>
 * 
 * 1. 必须先定义 enum 实例(否则编译错误),然后再是其他属性和方法<br>
 * 2. enum 序列最后一个元素后要添加分号<br>
 * 3. 构造器必须是 package 或者 private，因为 enum 实例会被翻译成 static final 的属性<br>
 * 如果是 public 的话，意味着 enum 实例还能改变，这不科学.如果改成 public，编译器会报错。<br>
 * 一旦 enum 的定义结束，编译器就不允许我们再使用其构造器来创建任何实例了
 */
public enum _02_OzWitch {
    WEST("this is west"), NORTH("this is north"), EAST("this is east"), SOUTH("this is south");

    private String description;

    private _02_OzWitch(String description) {
        this.description = description;
    }

    public String getDescrption() {
        return description;
    }

    public static void main(String[] args) {
        for (_02_OzWitch witch : _02_OzWitch.values()) {
            System.out.println(witch + ": " + witch.ordinal() + " " + witch.getDescrption());
        }
    }
}
