package Chapter11;

import java.util.*;

class Snow{}
class Powder extends Snow{}
class Light extends Snow{}
class Heavy extends Snow{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {
	public static void main(String[] args) {
		//在这里，Arrays.asList返回一个List。但是这个List中的元素不是我们想要的Snow，而是
		//最后一个元素的类型。也就是说返回的是一个List<Powder>类型
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		System.out.println(snow1);
		
		//不能编译的代码
		List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
		System.out.println(snow2);
		
		//Collections.addAll()不会报错
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());
		System.out.println(snow3);
		
		//如何解决不能编译的问题
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
		System.out.println(snow4);
		
	}
}
