package Chapter12;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("niu", "shuai");
		map.put("h", "s");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("niu", "niu");
		map = map2;
		System.out.println(map);
	}
}
