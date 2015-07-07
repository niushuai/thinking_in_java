package Chapter09.classprocessor;

/**
 * @author niushuai
 * 
 *  需要注意的是Apply的process方法中，Processor是一个类，而不是一个接口。那么，传入这个函数只能是Processor
 *  或者是Processor的子类。即使有一个Filter和Processor具有完全相同的结构，还是无法传入。这就给代码复用带来了
 *  一定的负面作用。
 */

import java.util.Arrays;

class Processor {
	public String name() {
		return getClass().getSimpleName();
	}
	Object process(Object input) {
		return input;
	}
}

class Upcase extends Processor {
	String process(Object input) {
		return ((String)input).toUpperCase();
	}
}

class Downcase extends Processor {
	String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter extends Processor {
	String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
}

public class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
	
	public static String s = "Disagreement with beliefs is by definition incorrect";
	
	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}
}
