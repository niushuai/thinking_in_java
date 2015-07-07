package Chapter09;

/**
 * 
 * @author niushuai
 * 
 *         extends和implements同时存在的时候，extends必须在前面，而且只能有一个，implementes逗号分隔即可
 */

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {

	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
	// class Hero implements CanFight, CanSwim, CanFly extends ActionCharacter{ 错误写法

	@Override
	public void fly() {

	}

	@Override
	public void swim() {

	}

	@Override
	public void fight() {

	}

}

public class Adventure {
	public static void t(CanFight x) {
		x.fight();
	}

	public static void u(CanSwim x) {
		x.swim();
	}

	public static void v(CanFly x) {
		x.fly();
	}

	public static void w(ActionCharacter x) {
		x.fight();
	}

	public static void main(String[] args) {
		System.out.println("hehe");
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
	}
}
