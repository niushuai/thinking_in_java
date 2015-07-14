package Chapter19;

/**
 * 刚开始看的时候丈二和尚摸不着头脑，为啥 ROCK 的里面是 SCISSORS，你妹的啊。。。
 * 
 * @author niushuai
 *
 */
public enum _22_RoShamBo4 implements Competitor<_22_RoShamBo4> {
    ROCK {
        public _18_Outcome compete(_22_RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        public _18_Outcome compete(_22_RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        public _18_Outcome compete(_22_RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };

    // 这里枚举了每个 enum 实例的失败方，所以如果对手是我写死的 loser，我就赢了
    public _18_Outcome compete(_22_RoShamBo4 loser, _22_RoShamBo4 opponent) {
        return ((opponent == this) ? _18_Outcome.DRAW : ((opponent == loser) ? _18_Outcome.WIN : _18_Outcome.LOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(_22_RoShamBo4.class, 20);
    }

}
