package Chapter11;

import java.util.*;

class SplitWord {
	
	public static HashSet<String> split(String str) {
		String[] strings = str.split("\\W+");
		HashSet<String> res = new HashSet<String>();
		for(String s : strings) {
			res.add(s);
		}
		return res;
	}
}

public class UniqueWords {
	public static void main(String[] args) {
		String str = "hello hello hello hello "
				+ "hello hello hello how are you? "
				+ "fdsfds fdsfdsf fds fds fdsf dsf sd afsdfsnlngla ";
		
		HashSet<String> s = SplitWord.split(str);
		System.out.println(s);
	}
}
