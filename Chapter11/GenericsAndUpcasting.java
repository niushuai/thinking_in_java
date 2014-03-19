package Chapter11;

/**
 *  @author niushuai
 * 
 *  输出中，@后面是hashCode()的值，根据内存hash出来的，基本不会重复。
 */

import java.util.ArrayList;

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Beaeburn extends Apple {}

public class GenericsAndUpcasting {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Beaeburn());
		
		for(Apple apple : apples) {
			System.out.println(apple);
		}
	}
}
