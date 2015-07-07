package Chapter13;

import java.util.*;

public class HelloScanner {
	public static int gcd(int m, int n) {
		if(m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		return n == 0 ? m : gcd(n, m - n);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for (int i = 0; i < num; ++i) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int res;
			if (m > n) {
				res = gcd(m, n);
			} else {
				res = gcd(n, m);
			}
			System.out.println(res);
		}
	}
}
