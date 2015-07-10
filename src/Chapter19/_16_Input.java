package Chapter19;

import java.util.Random;

/**
 * 一个售货机的几个元素：
 * 
 * 1. 商品，附带价格<br>
 * 2. 用户投入机器能识别的单位的钱<br>
 * 3. 取消操作<br>
 * 4. 购买完成，结束购买
 * 
 * @author niushuai02
 * 
 */
public enum _16_Input {
    // 能使用的单位
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),

    // 出售的商品
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),

    // 取消操作
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },

    // 结束购买
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    // 价格
    int value;

    // 构造售货机识别单位 & 商品价格
    private _16_Input(int value) {
        this.value = value;
    }

    // 构造两种操作，这实现太丑陋
    private _16_Input() {

    }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static _16_Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
