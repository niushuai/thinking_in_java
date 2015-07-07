package Chapter11;

import java.util.*;
import java.util.Map.Entry;

public class Exercise17 {
	public static void main(String[] args) {
		Map<String, Gerbil> gerbilMap = new HashMap<String, Gerbil>();
		gerbilMap.put("first", new Gerbil(1));
		gerbilMap.put("second", new Gerbil(2));
		gerbilMap.put("third", new Gerbil(3));
		gerbilMap.put("fourth", new Gerbil(4));
		
		Iterator<Entry<String, Gerbil>> it = gerbilMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Gerbil> entry = it.next();
			System.out.println(entry.getKey());
			entry.getValue().hop();
		}
	}
}
