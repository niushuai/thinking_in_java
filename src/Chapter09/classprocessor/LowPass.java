package Chapter09.classprocessor;

public class LowPass extends Filter {
	double cutoff;

	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
