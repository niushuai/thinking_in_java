package Chapter14;

public class GenericToyTest {
	public static void main(String[] args) {
		Class<FancyToy> ftClass = FancyToy.class;
		try {
			FancyToy fancyToy = ftClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<? super FancyToy> up = ftClass.getSuperclass();
		try {
			Object obj = up.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
