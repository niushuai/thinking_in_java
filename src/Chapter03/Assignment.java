package Chapter03;

class Tank {
	int level;
}

public class Assignment {
	public static void main(String[] args) {
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 9;
		t2.level = 47;
		System.out.println(t1.level + ", " + t2.level);
		t1 = t2;
		System.out.println(t1.level + ", " + t2.level); 
		t1.level = 27;
		System.out.println(t1.level + ", " + t2.level); 
	}
}
