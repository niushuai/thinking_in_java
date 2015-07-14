package Chapter19;

import static Chapter19._18_Outcome.DRAW;
import static Chapter19._18_Outcome.LOSE;
import static Chapter19._18_Outcome.WIN;

import java.util.EnumMap;

/**
 * 本质就是用 EnumMap 将所有情况枚举了一遍。。。
 * 
 * @author niushuai02
 *
 */
public enum _23_RoShamBo5 implements Competitor<_23_RoShamBo5> {
    PAPER, SCISSORS, ROCK;
    static EnumMap<_23_RoShamBo5, EnumMap<_23_RoShamBo5, _18_Outcome>> table =
            new EnumMap<_23_RoShamBo5, EnumMap<_23_RoShamBo5, _18_Outcome>>(_23_RoShamBo5.class);
    static {
        for (_23_RoShamBo5 it : _23_RoShamBo5.values()) {
            table.put(it, new EnumMap<_23_RoShamBo5, _18_Outcome>(_23_RoShamBo5.class));
        }

        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    static void initRow(_23_RoShamBo5 it, _18_Outcome vPAPER, _18_Outcome vSCISSORS, _18_Outcome vROCK) {
        EnumMap<_23_RoShamBo5, _18_Outcome> row = table.get(it);
        row.put(_23_RoShamBo5.PAPER, vPAPER);
        row.put(_23_RoShamBo5.SCISSORS, vSCISSORS);
        row.put(_23_RoShamBo5.ROCK, vROCK);
    }

    @Override
    public _18_Outcome compete(_23_RoShamBo5 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBo.play(_23_RoShamBo5.class, 10);
    }

}
