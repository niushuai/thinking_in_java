package Chapter11;

import java.util.ArrayList;

class Word {
	private String word;
}

public class Exercise03 {
	public static void main(String[] args) {
		ArrayList<Word> words = new ArrayList<Word>();
		for(int i = 0; i < 3; ++i) {
			words.add(new Word());
		}
	}
}
