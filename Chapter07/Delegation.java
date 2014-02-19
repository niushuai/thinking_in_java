package Chapter07;

class SpaceShip {
	public void up(int n) {
		System.out.println("up " + n + " meter");
	}
	public void down(int n) {
		System.out.println("down " + n + " meter");
	}
}

public class Delegation {
	private SpaceShip spaceShip = new SpaceShip();
	public void up(int n) {
		spaceShip.up(n);
	}
	public void down(int n) {
		spaceShip.down(n);
	}
	
	public static void main(String[] args) {
		Delegation delegation = new Delegation();
		delegation.up(3);
		delegation.down(5);
	}
}
