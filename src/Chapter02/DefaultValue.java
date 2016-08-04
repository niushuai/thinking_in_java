package Chapter02;

/***
 * 
 * @author niushuai
 * 
 * 查看int和char的默认值
 */
public class DefaultValue {
	int i;
	char ch;

	public static void main(String[] args) {
		DefaultValue defaultValue = new DefaultValue();
		System.out.println("default int is: " + defaultValue.i);
		System.out.println("default char is: " + defaultValue.ch);
	}
}
