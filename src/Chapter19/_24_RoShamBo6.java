package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

/**
 * 看到了久违的打表，突然想起来刚学会素数打表的日子....sigh
 * 
 * @author niushuai02
 *
 */
public enum _24_RoShamBo6 implements Competitor<_24_RoShamBo6> {
    PAPER, SCISSORS, ROCK;
    private static _18_Outcome[][] table = { { DRAW, LOSE, WIN }, { WIN, DRAW, LOSE }, { LOSE, WIN, DRAW } };

    public _18_Outcome compete(_24_RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(_23_RoShamBo5.class, 20);
    }
}
