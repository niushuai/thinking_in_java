package Chapter11;

import java.util.*;

class Favourite {
	private static Random random = new Random(47);
	private static final String[] films = new String[] { "guanlangaoshou",
			"huoyingrenzhe", "siquxiongdi", "longzhu", "labixiaoxin", };

	public static String next() {
		return films[random.nextInt(5)];
	}
}

public class Exercise04 {
	public static String[] fill(String[] args) {
		for(int i = 0; i < args.length; i++) {
			args[i] = Favourite.next();
		}
		return args;
	}
	public static Collection<String> fill(Collection<String> c) {
		for(int i = 0; i < 5; i++) {
			c.add(Favourite.next());
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fill(new String[5])));
		System.out.println(fill(new ArrayList()));
		System.out.println(fill(new LinkedList()));
		
	}
}
