package Chapter05;

class Mao {
	Mao(String s) {
		System.out.println(s);
	}
}

public class My {
	public static void main(String[] args) {
		Mao[] maos = new Mao[5]; //仅仅是引用，全部为null
		for(int i = 0;i < maos.length; ++i) {
			maos[i] = new Mao("haha");
		}
	}
}
