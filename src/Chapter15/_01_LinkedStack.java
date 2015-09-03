package Chapter15;

/**
 * 节点元素 + 下一个节点
 * 
 * @author niushuai
 *
 * @param <T>
 */
class Node<T> {
    T item;
    Node<T> next;

    Node() {
        item = null;
        next = null;
    }

    Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    boolean end() {
        return item == null && next == null;
    }
}

/**
 * 既然是栈，主要就是入栈和出栈了
 * 
 * @author niushuai
 *
 * @param <T>
 */
public class _01_LinkedStack<T> {
    // 栈底哨兵
    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }

        return result;
    }

    public static void main(String[] args) {
        _01_LinkedStack<String> lss = new _01_LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }

        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
