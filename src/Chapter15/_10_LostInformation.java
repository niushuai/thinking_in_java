package Chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test1 {

}

class Test2 {

}

class Test3<Q> {

}

class Test4<POSITION, MOMENT> {

}

public class _10_LostInformation {
    public static void main(String[] args) {
        List<Test1> list = new ArrayList<Test1>();
        Map<Test1, Test2> map = new HashMap<Test1, Test2>();
        Test3<Test2> tt = new Test3<Test2>();
        Test4<Long, Double> t4 = new Test4<Long, Double>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(tt.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(t4.getClass().getTypeParameters()));
    }
}/*
  * output: [E] [K, V] [Q] [POSITION, MOMENT]
  */