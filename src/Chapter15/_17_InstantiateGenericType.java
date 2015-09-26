package Chapter15;

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

// 第一个没问题，因为有默认的构造函数，但是 Integer 没有默认构造函数，所以在运行时会报错
public class _17_InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeed");

        ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        System.out.println("ClassAsFactory<Integer> failed");
    }
}
