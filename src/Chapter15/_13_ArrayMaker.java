package Chapter15;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 虽然 kind 被存储为{@code Class<T>}, 擦除后就是普通的 Class，没有 T 了。
 * 
 * 所以最后就是 Object，泛型完全无用。
 * 
 */
public class _13_ArrayMaker<T> {
    private Class<T> kind;

    public _13_ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        _13_ArrayMaker<String> stringMaker = new _13_ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
