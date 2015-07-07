package Chapter19;

/**
 * 如果想在枚举类中自己定义方法时:<br>
 * 
 * 1. 必须先定义 enum 实例(否则编译错误)<br>
 * 2. enum 序列最后要添加分号
 * 
 * @author niushuai
 *
 */
public enum _02_OzWitch {
    // 括号后面就是构建函数的参数啊！
    WEST("this is west"), NORTH("this is north"), EAST("this is east"), SOUTH("this is south");

    private String description;

    private _02_OzWitch(String description) {
        this.description = description;
    }

    public String getDescrption() {
        return description;
    }

    public static void main(String[] args) {

        System.out.println(_02_OzWitch.values());

        for (_02_OzWitch witch : _02_OzWitch.values()) {
            System.out.println(witch + ": " + witch.ordinal() + witch.getDescrption());
        }
    }
}
