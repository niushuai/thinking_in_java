package Chapter15;

import java.util.ArrayList;
import java.util.Random;

/**
 * 这例子也太弱智了= =
 * 
 * @author niushuai
 *
 * @param <T>
 */
public class _02_RandomList<T> {
    private Random random = new Random(47);
    private ArrayList<T> items = new ArrayList<T>();

    public void add(T item) {
        items.add(item);
    }

    public T randomSelect() {
        return items.get(random.nextInt(items.size()));
    }

    public static void main(String[] args) {
        _02_RandomList<String> items = new _02_RandomList<String>();
        for (String s : "hello world i am a coder".split(" ")) {
            items.add(s);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(items.randomSelect());
        }
    }
}
