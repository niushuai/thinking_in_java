package Chapter07;

import java.util.Random;

class Value {
	int i; // 包内变量

	public Value(int i) {
		this.i = i;
	}
}

public class FinalDate {
	private static Random random = new Random(47);
	private String id;
	public FinalDate(String id) {
		this.id = id;
	}
	
	//编译期确定
	private final int valueOne = 9;
	private static final int VALUE_TWO = 10;
	public static final int VALUE_THREE = 11;
	
	//运行时确定
	private final int valueFour = random.nextInt(20);
	static final int valueFive = random.nextInt(27);
	
	//引用类型，final保证不能更改引用。但是可以改变对象的值
	private Value v1 = new Value(30);
	private final Value v2 = new Value(31);
	private static final Value VALUEOBJECT_THREE = new Value(32);
	
	public static void main(String... args) {
		FinalDate finalDate = new FinalDate("1");
		//finalDate.valueOne = 10;
		finalDate.v1 = new Value(3333);
		//finalDate.v2 = new Value(23423);
	}
}
