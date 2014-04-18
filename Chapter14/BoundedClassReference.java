package Chapter14;

public class BoundedClassReference {
	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = int.class;
	}
}
