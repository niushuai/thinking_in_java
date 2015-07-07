package Chapter07;

/***
 * 
 * @author niushuai
 * 
 *         什么时候用组合？当你需要某个类的功能时，但同时它跟你没有共同点。比如一个汽车需要轮子，但汽车和轮子不沾边；
 *         什么时候用继承？当你需要表现某个类的接口时，你们有共同点。比如你要做一个领袖，你应该有领袖“有眼光”这个接口的功能，所以继承。
 */

class XianShiQi {
	public void on() {
		System.out.println("turn on");
	}

	public void off() {
		System.out.println("turn down");
	}
}

class CPU {
	public CPU() {
		this.on();
	}

	private void on() {
		System.out.println("CPU work");
	}

	private void off() {
		System.out.println("CPU down");
	}
}

class Memory {
	public Memory() {
		this.on();
	}

	private void on() {
		System.out.println("Memory work");
	}

	private void off() {
		System.out.println("Memory down");
	}
}

class IO {
	public void on() {
		System.out.println("IO work");
	}

	public void off() {
		System.out.println("IO down");
	}
}

public class MacPro {
	public XianShiQi xianShiQi = new XianShiQi();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	public IO io = new IO();

	public MacPro() {
		System.out.println("my macbook is on");
	}

	public static void main(String[] args) {
		MacPro macPro = new MacPro();
		macPro.xianShiQi.on();
		macPro.io.on();
		macPro.io.off();
		macPro.xianShiQi.off();
	}
}
