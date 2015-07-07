package Chapter11;

/**
 * @author niushuai
 * 
 *  这个就是适配器设计模式。因为Iterable<T>是一个接口，需要返回一个Iterator<T>。
 *  而既然我们想要实现多种foreach，如果类extends后，还是无法实现多种选择（只能是T变变）
 *  
 *  而我们如果适配器设计模式，产生一个生产Iterable<T>的方法。那么，我们就可以实现多种选择了。
 *  
 *  适配器设计模式是说，当你拥有一个接口（比如Iterable<T>）的时候，你还需要另外一个接口（产生多个
 *  Iterable<T>的对象的接口），就可以用适配器模式解决问题
 *  
 *  也不知道理解的对不对。。。。反正我感觉不靠谱(...逃
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reverse() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int index = size() - 1;

                    public boolean hasNext() {
                        return index > -1;
                    }

                    public T next() {
                        return get(index--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class AdaptMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral =
                new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : ral.reverse()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
