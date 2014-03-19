package Chapter09;

/**
 * 
 * @author niushuai
 * 
 *         这个其实就是工厂模式哪个例子的衍生品，我是一个玩游戏的玩家，
 *         我告诉电脑我喜欢玩哪种类型的游戏， 然后电脑就挑选一个合适的游戏给我。
 */

interface GameModel {
	void move();

	void kill();
}

class Game1 implements GameModel {
	public void move() {
		System.out.println("Game1 move()");
	}

	public void kill() {
		System.out.println("Game1 kill()");
	}
}

class Game2 implements GameModel {
	public void move() {
		System.out.println("Game2 move()");
	}

	public void kill() {
		System.out.println("Game2 kill()");
	}
}

interface GameType {
	GameModel getGame();
}

class GameType1 implements GameType {
	public GameModel getGame() {
		return new Game1();
	}
}

class GameType2 implements GameType {
	public GameModel getGame() {
		return new Game2();
	}
}

public class IloveGame {
	public static void selectGame(GameType g) {
		GameModel gameModel = g.getGame();
		gameModel.move();
		gameModel.kill();
	}

	public static void main(String[] args) {
		selectGame(new GameType1());
		selectGame(new GameType2());
	}
}
