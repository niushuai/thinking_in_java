package Chapter07;

class Instrument {
	public void play() {
		
	}
	public static void tune(Instrument i) {
		i.play();
	}
}

public class Wind extends Instrument{
	public static void main(String[] args) {
		Wind wind = new Wind();
		Instrument.tune(wind);
	}
}
