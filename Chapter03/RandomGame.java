package Chapter03;

import java.util.Random;

class RandomInit {
	public static int number(int x) {
		Random random = new Random();
		return random.nextInt(x);
	}
}

class Player {
	public int guess(int x) {
		Random random = new Random();
		return random.nextInt(x);
	}
}

class Launcher {
	public void start() {
		while (true) {
			int number = RandomInit.number(20);
			Player p1 = new Player();
			Player p2 = new Player();
			int guess1 = p1.guess(20);
			int guess2 = p2.guess(20);
			System.out.println("Number is: " + number);
			System.out.println("player1 guess number: " + guess1);
			System.out.println("player2 guess number: " + guess2);
			
			if(guess1 == number && guess2 != number) {
				System.out.println("player1 win!");
				break;
			}
			else if(guess1 != number && guess2 == number) {
				System.out.println("player2 win!");
				break;
			} else if(guess1 == number && guess2 == number) {
				System.out.println("player1 and player2 both win!");
				break;
			}
		}
	}
}

public class RandomGame {
public static void main(String[] args) {
	Launcher launcher = new Launcher();
	launcher.start();
}	
}
