package Chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }
}

public class _07_LimitsOfInference {
    static void f(Map<String, List<? extends Integer>> argu) {

    }

    public static void main(String[] args) {
        f(New.map());
    }
}
