package Chapter09;

/**
 * 
 * @author niushuai
 *
 *	原来接口也可以继承。。。这个以前真没注意到。。。。。
 */

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void distroy();
}

public class HorrorShow implements DangerousMonster {
	public void menace() {}
	public void distroy() {}
	public static void main(String[] args) {
		DangerousMonster dangerousMonster = new HorrorShow();
		dangerousMonster.menace();
		dangerousMonster.distroy();
	}
}
