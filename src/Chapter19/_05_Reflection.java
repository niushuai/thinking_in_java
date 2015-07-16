package Chapter19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore {
    HERE, THERE
}

/**
 * 运行程序后，发现增加了values()方法。这是编译器添加的static方法。一共添加了2个：
 * <p>
 * 
 * 1. values()<br>
 * 2. 重载版本的valueOf()
 * <p>
 * 
 * 如果使用<code>javap</code>看下生成的HERE和THERE类，会发现他们是static final Explore HERE,所以枚举类不能被继承。
 */
public class _05_Reflection {
    /**
     * 打印一个类的接口，父类，方法。
     * 
     * @param enumClass
     * @return
     */
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("Analyzing " + enumClass + " ...");
        System.out.println("实现的接口: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("父类: " + enumClass.getSuperclass());
        System.out.println("方法列表: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        System.out.println("============");
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("============");

        System.out
                .println("Explore是否含有Enum的全部方法？Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));

        System.out.println("============");
        System.out.println("Explore去掉Enum的全部方法。Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println("去掉后剩下的方法： " + exploreMethods);
    }
}
