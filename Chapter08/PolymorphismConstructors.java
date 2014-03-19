package Chapter08;

/**
 * 
 * @author niushuai
 *
 * 这段程序告诉我们，尽量不要在构造函数中调用其他函数。如果一定调用，请努力向final靠近。
 * 1. 先将存储空间置0
 * 2. 基类的draw()调用的是导出类的draw()，但是基类都没有构造成功，导出类肯定没有构造成功。所以肯定出错。
 */

class Glyph {
	void draw() {
		System.out.println("Glyph draw()");
	}
	Glyph() {
		System.out.println("Glyph before draw()");
		draw();
		System.out.println("Glyph after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int i) {
		radius = i;
		System.out.println("RoundGlyph.RoundGlyph, radius = " + radius);
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}

public class PolymorphismConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}
