package Chapter02;

/***
 * 
 * @author niushuai
 * 
 *         1. 从运行程序的系统中获取的所有“属性”，list()将结果发送到System.out 
 *         2. 获取用户名 
 *         3. java.libraray.path
 */

public class ShowProperties {
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.libraray.path"));
	}
}
