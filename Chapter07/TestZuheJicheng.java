package Chapter07;

class Intel {
	public void buy() {
		System.out.println("intel Cpu");
	}
}

class lenovo {
	private Intel intel = new Intel();

	public void buy() {
		System.out.println("lenovo");
	}
}

class thinkpad {
	private Intel intel = new Intel();

	public void buy() {
		System.out.println("thinkpad");
	}
}

class Macbook {
	private Intel intel = new Intel();

	public void buy() {
		System.out.println("macbook");
	}
}

class SuperMacbook extends Macbook {
	public void buyOther() {
		System.out.println("desk computer");
	}
}

public class TestZuheJicheng {
	public static void main(String[] args) {
		SuperMacbook superMacbook = new SuperMacbook();
	}
}
