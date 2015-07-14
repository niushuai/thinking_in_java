package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

/**
 * 用了常量相关的方法，啥 constant specific method，特别像多态
 */
public enum _21_RoShamBo3 implements Competitor<_21_RoShamBo3> {
    PAPER {
        public _18_Outcome compete(_21_RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return DRAW;
                case SCISSORS:
                    return LOSE;
                case ROCK:
                    return WIN;
            }
        }
    },
    SCISSORS {
        public _18_Outcome compete(_21_RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return WIN;
                case SCISSORS:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK {
        public _18_Outcome compete(_21_RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    public abstract _18_Outcome compete(_21_RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(_21_RoShamBo3.class, 20);
    }

}
