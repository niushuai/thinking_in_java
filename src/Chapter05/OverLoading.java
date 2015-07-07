package Chapter05;

class Tree {
	int height;
	Tree() {
		System.out.println("Planting a seedling");
		height = 0;
	}
	
	Tree(int init) {
		height = init;
		System.out.println("Creating a new tree with :" + height);
	}
	
	void info() {
		System.out.println("Tree is:" + height + " feet tall");
	}
	
	void info(String s) {
		System.out.println(s + ": Tree is:" + height + " feet tall");
	}
}

public class OverLoading {
	public static void main(String[] args) {
		for(int i = 0; i < 5; ++i) {
			Tree t = new Tree(i);
			t.info();
			t.info("overloaded method");
		}
		new Tree();
	}
}
