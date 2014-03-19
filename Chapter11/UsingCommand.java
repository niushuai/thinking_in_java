package Chapter11;

/**
 * @author niushuai
 * 
 * 这个例子是一个简单C/S通信。C写入命令后送到Queue中，S收到命令后执行
 * 
 * 需要注意的有几点：
 * 1. 使用的Queue必须使用插入有序的容器来初始化，用ArrayList无法保证插入顺序，所以不行；而LinkedList能保持
 * 	  输入有序，所以可以。
 * 2. 使用Queue的话，会消除C/S之间的耦合性。C只管写，不需要等待S的处理。S只管执行，完成后发送给C一个消息即可
 * 3. 使用Queue能保证输入/输出交接的是完整性,而main相当于一个Controller来负责C/S之间的通信
 */

import java.util.*;

class Command {
	private final String str;

	Command(String cmd) {
		str = cmd;
	}
	public void print() {
		System.out.println(str);
	}
}

class TempQueue {
	public static void temp(Queue<Command> queue) {
		queue.offer(new Command("cd /usr/home/niushuai"));
		queue.offer(new Command("ls"));
		queue.offer(new Command("cp *.java /usr/home/other/"));
	}
}

class Server {
	public static void exec(Queue<Command> queue) {
		while(queue.peek() != null) {
			queue.remove().print();
		}
		System.out.println("ok!");
	}
}

public class UsingCommand {
	public static void main(String[] args) {
		Queue<Command> queue = new LinkedList<Command>();
		
		//客户端产生命令
		TempQueue.temp(queue);
		
		//服务器端执行命令
		Server.exec(queue);
	}
}
