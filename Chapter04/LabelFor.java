package Chapter04;

/**
 * 
 * @author niushuai
 * 
 * 使用标签，其实就是goto。。。有时候确实有用，就是在某个内层循环解决了业务问题，需要函数级返回。
 */

public class LabelFor {
	public static void main(String[] args) {
		int i = 0;
		outer: for (; true;) {
			inner: for (; i < 10; i++) {
				System.out.println("i = " + i);
				if (i == 2) {
					System.out.println("continue");
					continue;
				}
				if (i == 3) {
					System.out.println("break");
					i++;
					break;
				}
				if (i == 7) {
					System.out.println("continue outer");
					i++;
					continue outer;
				}
				if (i == 8) {
					System.out.println("break outer");
					break outer;
				}
				for (int k = 0; k < 5; ++k) {
					if (k == 3) {
						System.out.println("continue inner");
						continue inner;
					}
				}
			}
		}
		System.out.println("finish");
	}
}
