package Chapter10;

/**
 * 
 * @author niushuai
 *
 * 在我的理解中，内部类是为了多重继承的完整性而提出的。现在假如有个interface为特殊功能（里面只有一个特殊功能），
 * 另外有一个superman类，超人有N个特殊功能，但是如果外部类实现这个接口，就只能拥有一个特殊功能。但使用内部类的
 * 话，我可以在内部创建4个private class implements 特殊功能，然后通过public释放这4个特殊功能的接口。这样，
 * 在外部看来，就算是实现了多重继承。并且因为释放的是公共接口，内部类实现外部是无法看见的。当有变化的时候，内部修改完全
 * 不影响外部的使用。而且扩展起来也非常方便。
 * 
 * 所以接口（抽象类）+内部类完全可以做到多重继承，同时保证了数据的访问权限。
 */

interface Destination {
	String readLabel();
}

interface Content {
	int value();
}

class Parcel4 {
	private class PContent implements Content {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	protected class PDestination implements Destination {
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
	}
	
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Content content() {
		return new PContent();
	}
}

public class TestParcel {
	public static void main(String[] args) {
		Parcel4 parcel4 = new Parcel4();
		Destination destination = parcel4.destination("hello");
		Content content = parcel4.content();
	}
}
