package Chapter11;

import java.util.ArrayList;

class Gerbil {
	private int gerbilNumber;
	public Gerbil(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}
	public void hop() {
		System.out.println("Number is :" + gerbilNumber + ", Gerbil.hop()");
	}
}

public class Exercise01 {
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		for(int i = 0; i < 3; i++) {
			gerbils.add(new Gerbil(i + 1));
		}
		
		for(int i = 0; i < gerbils.size(); i++) {
			gerbils.get(i).hop();
		}
		
		for(Gerbil gerbil : gerbils) {
			gerbil.hop();
		}
	}
}
