package Chapter19;

import static Chapter19.AlarmPoints.BATHROOM;
import static Chapter19.AlarmPoints.KITCHEN;
import static Chapter19.AlarmPoints.OFFICE1;
import static Chapter19.AlarmPoints.OFFICE2;
import static Chapter19.AlarmPoints.STAIR1;
import static Chapter19.AlarmPoints.STAIR2;

import java.util.EnumSet;

// 大楼中放置警报传感器的位置
enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN;
}

public class _25_EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set

        points.add(BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);

        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        // 将[OFFICE1.ordinal()到 OFFICE2.ordinal()]删除, range 是闭区间
        points.removeAll(EnumSet.range(OFFICE1, OFFICE2));
        System.out.println(points);

        // 取complementOf()中参数 EnumSet 的补集
        points = EnumSet.complementOf(points);
        System.out.println(points);

    }
}
