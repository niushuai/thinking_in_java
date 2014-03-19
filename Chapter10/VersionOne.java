package Chapter10;

interface ComputerModel {
	void startup();
	void play();
}

class MacBook implements ComputerModel {
	public void startup() {
		System.out.println("MacBook startup!");
	}
	public void play() {
		System.out.println("MacBook play!");
	}
}

class ThinkPad implements ComputerModel {
	public void startup() {
		System.out.println("ThinkPad startup!");
	}
	public void play() {
		System.out.println("ThinkPad play!");
	}
}

interface ComputerCompany {
	ComputerModel produce();
}

class Apple implements ComputerCompany {
	public ComputerModel produce() {
		return new MacBook();
	}
}

class Lenovo implements ComputerCompany {
	public ComputerModel produce() {
		return new ThinkPad();
	}
}

class ComputerStore {
	public static ComputerModel sell(ComputerCompany company) {
		return company.produce();
	}
}


public class VersionOne {
	public static void main(String[] args) {
		ComputerModel computer = ComputerStore.sell(new Apple());
		computer.startup();
		computer.play();
		
		System.out.println();
		ComputerModel computer2 = ComputerStore.sell(new Lenovo());
		computer2.startup();
		computer2.play();
	}
}
