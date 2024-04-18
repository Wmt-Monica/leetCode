package google.linked;

/**
 * @Classname Node
 * @Description TODO
 * @Date 2021/7/14 19:21
 * @Created by 翊
 */
public class Node {
    private char data;
    private Node next;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node() {}

    public Node(char data) {
        this.data = data;
    }

    public Node(char data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
