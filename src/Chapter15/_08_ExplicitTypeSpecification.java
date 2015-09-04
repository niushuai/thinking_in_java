package Chapter15;

import java.util.HashMap;
import java.util.Map;

public class _08_ExplicitTypeSpecification {

    // 这里是静态方法的 new
    static class StaticNew {
        public static <K, V> Map<K, V> map() {
            return new HashMap<K, V>();
        }
    }

    // 普通实例化的 new
    class InstanceNew {
        public <K, V> Map<K, V> map() {
            return new HashMap<K, V>();
        }
    }

    // 类内部的 new
    public <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    static void test1(Map<Integer, String> map) {

    }

    public void main() {
        // compile error, StaticNew.map() return Map<Object, Object>, but test1 requried Map<Integer, String>
        test1(StaticNew.map());
        // compile ok. 等价于Map<Integer, String> map = StaticNew.<Integer, String>map();
        test1(StaticNew.<Integer, String> map());

        // compile error, InstanceNew.map() return Map<Object, Object>, but test1 requried Map<Integer, String>
        test1(new InstanceNew().map());
        // compile ok. 等价于Map<Integer, String> map2 = new InstanceNew().<Integer, String>map();
        test1(new InstanceNew().<Integer, String> map());

        // compile error, this.map() return Map<Object, Object>, but test1 requried Map<Integer, String>
        test1(this.map());
        // compile ok. 等价于Map<Integer, String> map = this.<Integer, String>map();
        test1(this.<Integer, String> map());
    }
}
