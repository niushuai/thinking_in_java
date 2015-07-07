package Chapter03;

/***
 * 
 * @author niushuai
 * 
 *         output is: false, true, true.因为比较的是*引用*，两次new出来的对象肯定不一样。
 *         如果想一样，需要自己实现equals(),重载equals的话必须重载hashCode
 *         ==比较的是引用，equals才是比较对象
 */

public class EqualValence {
	public static void main(String[] args) {
		Integer n1 = new Integer(2014);
		Integer n2 = new Integer(2014);
		System.out.println(n1 == n2);
		System.out.println(n1 != n2);

		System.out.println(n1.equals(n2));
	}
}
