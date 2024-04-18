package google.linked;

/**
 * @Classname OrderInsert
 * @Description TODO
 * @Date 2021/7/15 14:03
 * @Created by 翊
 * 链表有序插入节点
 */
public class OrderInsert {
    // 创建一个哨兵节点，指向头节点的前一个节点
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public OrderInsert() {
        // 初始化 head,不存放实际数据，但是不能为 null,避免后续操做的空指针异常
        this.head = new Node();
    }

    // 有序插入数据
    public void orderInsert(Node addNode) {
        // 当链表中为空，直接插入的节点 addNode 插入到 head.next 位置
        if (head.getNext() == null) {
            head.setNext(addNode);
        } else {
            // 创建 node 节点指向 head,用于遍历链表指针
            Node node = head;
            // 当 node.next == null 或者 node.next.data > addNode.data 跳出循环遍历
            while (node.getNext() != null && node.getNext().getData() <= addNode.getData()) {
                node = node.getNext();
            }
            // 将 addNode 插入到 node.next 域中
            addNode.setNext(node.getNext());
            node.setNext(addNode);
        }
    }

    // 合并两个有序链表
    // 方法上引用的两个链表的头节点只是创建新的变量赋值了两个链表的头节点的值，
    // 之后的操作不会对原先的链表产生影响，注意的是在将两个链表中的节点添加到新的
    // 链表当中不是单纯的将链接的节点添加到 newNode.next 域中，而是根据其节点重新
    // 创建心的节点，一面后续对两个链表之间的遍历比较造成影响
    public Node merge(Node n1, Node n2) throws InterruptedException {

        // 创建新链表的头节点
        Node newNode = new Node();
        Node n3 = newNode; // 创建 n3 指针指向 newNode 的尾节点

        while (n1.getNext() != null && n2.getNext() != null) {

            if (n1.getNext().getData() <= n2.getNext().getData()) {
                n3.setNext(new Node(n1.getNext().getData()));
                n3 = n3.getNext();
                n1 = n1.getNext();
            } else {
                n3.setNext(new Node(n2.getNext().getData()));
                n3 = n3.getNext();
                n2 = n2.getNext();
            }
        }

        // 循环链接剩余不用比较的链表部分到新链表当中去
        while (n1.getNext() != null) {
            n3.setNext(n1.getNext());
            n3 = n3.getNext();
            n1 = n1.getNext();
        }
        while (n2.getNext() != null) {
            n3.setNext(n2.getNext());
            n3 = n3.getNext();
            n2 = n2.getNext();
        }

        return newNode;

    }

    // 打印链表
    public void print(Node head) {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData()+"\t");
            node = node.getNext();
        }
        System.out.println();
    }
}
