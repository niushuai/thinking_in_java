package Chapter19;

import java.util.EnumSet;

enum Cycle {

    UNDERBODY {
        void action() {
            System.out.println("泡沫喷洒车身");
        }
    },
    WHEELWASH {
        void action() {
            System.out.println("清洗车轮");
        }
    },
    PREWASH {
        void action() {
            System.out.println("清洗大块灰尘");
        }
    },
    BASIC {
        void action() {
            System.out.println("开始正常清洗");
        }
    },
    HOTWAX {
        void action() {
            System.out.println("开始凃蜡");
        }
    },

    RINSE {
        void action() {
            System.out.println("冲洗车身");
        }
    },

    BLOWDRY {
        void action() {
            System.out.println("吹干车身");
        }
    };

    abstract void action();
}

/**
 * 本文描述了一个屌丝车主和土豪任性女朋友的故事。
 * 
 * 1. 虽然女朋友任性想多打打蜡（重复添加 Cycle.BLOWDRY），然并卵。<br>
 * EnumSet不允许，因为 EnumSet 内部实现是 long 的64位（RegularEnumSet 或 JumboEnumSet），你不可能让 bit 位打开多次吧？
 * 
 * @author niushuai02
 * 
 */
public class _14_CarWash {
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }

    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        System.out.println("屌丝车主来洗车啦...");
        _14_CarWash wash = new _14_CarWash();
        System.out.println("选择套餐为： " + wash);
        wash.washCar();
        System.out.println("===========");

        System.out.println("屌丝车主的土豪女朋友来啦...");
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY); // 有钱就要做两次？还这么任性不按流程，先吹风再冲洗打蜡，你TM在逗我们洗车工？
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println("升级套餐后：" + wash);
        wash.washCar();

    }
}
