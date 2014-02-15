package Chapter02;

/***
 * 
 * @author niushuai
 * 
 *         Entity array[] = new Entity[10]定仅仅义了10个引用，与C++要区分清楚
 */

class Entity {
	static int staticNum; //默认初始化为0

	public Entity() {
		staticNum++;
	}

	public static void printStaticNum() { //使用static属性使用static方法
		System.out.println(staticNum);
	}
}

public class StaticClassOnly {
	public static void main(String[] args) {
		Entity array[] = new Entity[10]; // 定义10个对象的引用
		for (int i = 0; i < 10; ++i) {
			array[i] = new Entity(); // 创建10个对象
		}
		Entity.printStaticNum();
	}
}
