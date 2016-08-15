package Chapter02;

/***
 * 
 * @author niushuai
 * 
 * 在Chapter01的上一层目录执行java Chapter01.CommandArgu happy new year
 */

public class CommandArgu {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
    }
}
