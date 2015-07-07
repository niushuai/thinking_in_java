package Chapter08;

/**
 * 
 * @author niushuai
 *
 * 对域来说是由编译器解析的，因此不是多态的。
 */

class Super2 {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub2 extends Super2 {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}

public class FieldAccess {
	public static void main(String[] args) {
		Super2 super2 = new Sub2();
		System.out.println("sup.field = " + super2.field
				+ ", super.getField() = " + super2.getField());
		Sub2 sub = new Sub2();
		System.out.println("sub.field = " + sub.field + ", sub.getField() = "
				+ sub.getField() + ", sub.getSuperField() = "
				+ sub.getSuperField());

	}
}
