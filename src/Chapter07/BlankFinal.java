package Chapter07;

/***
 * 
 * @author niushuai
 * 
 *         示例了空白final的用法，这个比较灵活：可以根据构造函数来初始化。但是记得对于final属性：
 * 			1. 在定义出就初始化
 * 			2. 在构造函数中初始化
 * 			3. 除了上面2种，其它都是错误的（不能在非构造函数的其它的其它函数中初始化）
 */

class Poppet {
	private int i;

	public Poppet(int i) {
		this.i = i;
	}
}

public class BlankFinal {
	private final int i = 0;
	private final int j;
	private final Poppet poppet;

	public BlankFinal() {
		j = 1;
		poppet = new Poppet(1);
	}

	public BlankFinal(int i) {
		j = i;
		poppet = new Poppet(i);
	}

	public static void main(String... args) {
		BlankFinal blankFinal = new BlankFinal();
		BlankFinal blankFinal2 = new BlankFinal(3);
	}
}
