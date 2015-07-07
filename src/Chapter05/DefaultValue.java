package Chapter05;

public class DefaultValue {
	byte b;
	boolean bool;
	char c;
	int i;
	short s;
	long l;
	float f;
	double d;
	DefaultValue defaultValue;
	
	void print() {
		System.out.println("Date type    Initial Value");
		System.out.println("byte         " + b);
		System.out.println("boolean         " + bool);
		System.out.println("char         [" + c + "]");
		System.out.println("int         " + i);
		System.out.println("short         " + s);
		System.out.println("long         " + l);
		System.out.println("float         " + f);
		System.out.println("dobule         " + d);
		System.out.println("reference         " + defaultValue);
	}

	public static void main(String[] args) {
		new DefaultValue().print();
	}
}
