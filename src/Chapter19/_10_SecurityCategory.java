package Chapter19;

/**
 * 所谓的将一个enum嵌套在另一个enum。。。和前面那个例子就是一样的好吗！！！额，好吧，这个只是没把interface提出去
 * 
 * @author niushuai02
 * 
 */
public enum _10_SecurityCategory {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;

    interface Security {
        enum Stock implements Security {
            SHORT, LOG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    private _10_SecurityCategory(Class<? extends Security> value) {
        values = value.getEnumConstants();
    }

    public Security show() {
        return values[0];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Security s = _10_SecurityCategory.STOCK.show();
            System.out.println(s);
        }
    }
}
