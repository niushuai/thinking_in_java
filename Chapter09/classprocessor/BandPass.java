package Chapter09.classprocessor;

public class BandPass extends Filter {
	double lowCutoff, highCutoff;

	public BandPass(double lowcut, double highcut) {
		lowCutoff = lowcut;
		highCutoff = highcut;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
