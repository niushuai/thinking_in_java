package Chapter10;

/**
 * 
 * @author niushuai
 * 
 * 外部类必须可以调用内部类的private成员啊，我的地盘必须我做主啊。
 * 但是调用之前得先创建一个对象，因为人家毕竟是个对象啊。。。。我竟然犯糊涂了 唉。
 */

public class TestInnerPrivate {
	class InnerPrivate {
		private int i = 4;
	}
	
	public int change() {
		InnerPrivate innerPrivate = new InnerPrivate();
		innerPrivate.i = 3;
		return innerPrivate.i;
	}
	
	public static void main(String[] args) {
		TestInnerPrivate testInnerPrivate = new TestInnerPrivate();
		System.out.println(testInnerPrivate.change());
		
	}
}
