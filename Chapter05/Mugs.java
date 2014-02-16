package Chapter05;

class Luo {
	String name;
	Luo(int n) {
		System.out.println("Luo(" + n + ")");
	}
}

class Luos {
	Luo luo1;
	Luo luo2;
	{
		luo1 = new Luo(1);
		luo2 = new Luo(2);
	}
	Luos() {
		System.out.println("Luo()");
	}
}

public class Mugs {
	public static void main(String[] args) {
		new Luos();
	}
}
