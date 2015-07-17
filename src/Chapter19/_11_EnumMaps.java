package Chapter19;

import java.util.EnumMap;
import java.util.Map;

interface Command {
    void action();
}

enum AlartPoints {
    KITCHEN, BEDROOM, BATHROOM;
}

/**
 * 注意：<br>
 * 1. EnumSet和EnumMap一样，它们中存放的元素不管以怎样的顺序add进去，<br>
 * 遍历的时候都是按照定义的次序展现(下面会先输出KITCHEN)。 <br>
 * 2. 如果EnumMap中没有某个enum实例，get的时候会得到一个NPE
 */
public class _11_EnumMaps {
    public static void main(String[] args) {
        
        System.out.println(Integer.toHexString(-3));
        EnumMap<AlartPoints, Command> em = new EnumMap<AlartPoints, Command>(AlartPoints.class);

        em.put(AlartPoints.BEDROOM, new Command() {
            @Override
            public void action() {
                System.out.println("bedroom is fire");
            }
        });

        em.put(AlartPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("kitchen is fire");
            }
        });

        // em.put(AlartPoints.KITCHEN, new Command() {
        // @Override
        // public void action() {
        // System.out.println("bathroom is fire");
        // }
        // });

        for (Map.Entry<AlartPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        em.get(AlartPoints.BATHROOM).action();
    }
}
