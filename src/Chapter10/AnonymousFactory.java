package Chapter10;

interface Computer {
	void typing();
}

interface ProduceComputer {
	Computer produce();
}

class ThinComputer implements Computer {
	public void typing() {
		System.out.println("Thin Computer");
	}
	public static ProduceComputer produceComputer = 
			new ProduceComputer() {
		public Computer produce() {
			return new ThinComputer();
		}
	};
}

class ThickComputer implements Computer {
	public void typing() {
		System.out.println("Thick Computer");
	}
	public static ProduceComputer produceComputer = 
			new ProduceComputer() {
		public Computer produce() {
			return new ThickComputer();
		}
	};
}

public class AnonymousFactory {
	public static void selectComputer(ProduceComputer p) {
		Computer computer = p.produce();
		computer.typing();
	}
	public static void main(String[] args) {
		selectComputer(ThinComputer.produceComputer);
		selectComputer(ThickComputer.produceComputer);
	}
}
