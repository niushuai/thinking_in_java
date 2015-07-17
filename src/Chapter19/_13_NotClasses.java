package Chapter19;

enum LikeClasses {
    SING {
        void behaviour() {
            System.out.println("I'm singing.");
        }
    },

    RUN {
        void behaviour() {
            System.out.println("I'm running.");
        }
    },

    PLAY {
        void behaviour() {
            System.out.println("I'm playing.");
        }
    };

    abstract void behaviour();
}

/**
 * 
 * 悲剧，下面这句无法编译通过。说明enum实例不能当做class类型啊！！ <br>
 * 因为SING/RUN/PLAY编译后都是static final实例。就比如f2的例子一样
 * 
 * @author niushuai02
 * 
 */
public class _13_NotClasses {

    // void f1(LikeClasses.RUN a) {}

    void f1(LikeClasses a) {
    }

    public static final String HELLO = "hello";

    // void f2(HELLO) {}
}
