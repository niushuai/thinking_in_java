package Chapter08;

enum Note {
		DOU, RUAI, MI, FA, SAO, LA, XI
}

class Instrument {
	void play(Note n) {
		System.out.println("Instrument play() " + n);
	}
	String what() {
		return "Instrument";
	}
	void adjust() {
		System.out.println("Instrument adjust()");
	}
}

class Wind extends Instrument {
	void play(Note n) {
		System.out.println("Wind play() " + n);
	}
	String what() {
		return "Wind";
	}
	void adjust() {
		System.out.println("Wind adjust()");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		System.out.println("Node play() " + n);
	}
	String what() {
		return "Percussion";
	}
	void adjust() {
		System.out.println("Percussion adjust()");
	}
}

public class Music {
	public static void tune(Instrument i) {
		i.play(Note.DOU);
	}
	public static void tuneAll(Instrument[] i) {
		for(Instrument e : i) {
			tune(e);
		}
	}
	public static void main(String[] args) {
		Instrument[] instruments = {
				new Wind(),
				new Percussion()
		};
		tuneAll(instruments);
	}
}
