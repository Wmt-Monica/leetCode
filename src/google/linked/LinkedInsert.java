package google.linked;

/**
 * @Classname LinkedInsert
 * @Description TODO
 * @Date 2021/7/15 10:31
 * @Created by 翊
 * 练习链表插入节点中的头插法和尾插法
 */
public class LinkedInsert {

    // 使用哨兵，指向 firstNode 的前一个节点
    private Node head;
    // 指向最后一个有效节点
    private Node lastNode;

    public LinkedInsert() {
        // 初始化哨兵节点和尾节点，不存放实际的数据，但是也不能让其为 null
        this.head = new Node();
        this.lastNode = new Node();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    // 头插法
    public void headInsertion(Node newNode) {
        // 由于是头插法，所以插入第一个节点时，将 lastNode 赋值为 newNode
        if (head.getNext() == null) {
            lastNode = newNode;
        }
        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    // 尾插法
    public void tailInsertion(Node newNode) {
        // 插入第一个节点时
        if (head.getNext() == null) {
            head.setNext(newNode);
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    // 遍历链表
    public void traverse(Node head) {
        Node node = head.getNext();
        while (node != null) {
            System.out.println("node = "+node);
            node = node.getNext();
        }
    }
}
