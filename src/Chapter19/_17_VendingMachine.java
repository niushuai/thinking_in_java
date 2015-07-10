package Chapter19;

import static Chapter19._16_Input.ABORT_TRANSACTION;
import static Chapter19._16_Input.CHIPS;
import static Chapter19._16_Input.DIME;
import static Chapter19._16_Input.DOLLAR;
import static Chapter19._16_Input.NICKEL;
import static Chapter19._16_Input.QUARTER;
import static Chapter19._16_Input.SOAP;
import static Chapter19._16_Input.SODA;
import static Chapter19._16_Input.STOP;
import static Chapter19._16_Input.TOOTHPASTE;

import java.util.EnumMap;

interface Generator<T> {
    T next();
}

class RandomInputGenerator implements Generator<_16_Input> {
    public _16_Input next() {
        return _16_Input.randomSelection();
    }
}

/**
 * 上演了枚举嵌套枚举。
 * 
 * @author niushuai02
 * 
 */
enum Category {
    // 金钱面额
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    // 商品列表
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    // 取消
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    // 完成
    SHUT_DOWN(STOP);

    private _16_Input[] values;

    private Category(_16_Input...values) {
        this.values = values;
    }

    // 每种售货机东西都关联Category
    private static EnumMap<_16_Input, Category> categories = new EnumMap<_16_Input, Category>(_16_Input.class);
    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (_16_Input type : c.values) {
                categories.put(type, c);
            }
        }
    }

    public static Category getCategory(_16_Input input) {
        return categories.get(input);
    }
}

/**
 * State定义了售货机的几种状态：
 * 
 * 1. 空闲 2. 投钱 3. 出货 4. 找零 5. 结束购买
 * 
 * @author niushuai02
 * 
 */
public class _17_VendingMachine {
    // 空闲状态
    private static State state = State.RESTING;
    // 投币金额
    private static int amount = 0;
    // 选择商品
    private static _16_Input selection = null;

    enum StateDuration {
        TRANSIENT;
    }

    enum State {
        RESTING {
            void next(_16_Input input) {
                switch (Category.getCategory(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(_16_Input input) {
                switch (Category.getCategory(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("金额不足购买： " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        // 下面是2个瞬时状态，其实按常理说，DISPENSING不应该是瞬时的，买完还可以继续买啊！到达找零应该增加一个按钮让用户显式触发
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    System.out.println("找零： " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output() {
                System.out.println("结束本次购物！欢迎下次光临");
            }
        };

        private boolean isTransient = false;

        State() {

        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(_16_Input input) {
            throw new RuntimeException("Only call next(_16_Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println("当前余额: " + amount);
        }
    }

    static void run(Generator<_16_Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<_16_Input> gen = new RandomInputGenerator();
        run(gen);
    }
}
