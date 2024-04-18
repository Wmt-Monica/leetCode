package google.linked;

/**
 * @Classname LRU
 * @Description TODO
 * @Date 2021/7/14 20:50
 * @Created by 翊
 * LRU (最久未使用)逻辑单链表实现
 */
public class LRU {
    // 为该进程分配的物理块数量
    private int size;

    private int n = 0;

    // 进程运行时执行页号的序列
    private String s;

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public LRU(int size, String s) {
        this.size = size;
        this.s = s;
    }

    // 使用 LRU 的缓存算法
    public void cache() {
        for (char c : s.toCharArray()) {
            System.out.println("c = " + c);
            insert(c);
            Node node = head;
            System.out.println("==================打印链表中的数据================");
            while (node != null) {
                System.out.print(node.getData()+"\t");
                node = node.getNext();
            }
            System.out.println("\n================================================");
        }
    }

    // 当此数据 c 已经被缓存在链表中，那么将其从原来的位置中删除，然后从新插入道链表的头部
    public void insert(char c) {
        System.out.println("head = "+head);
        if (head == null) {
            head = new Node(c);
            n ++;
            System.out.println("链表头节点为 null,将 head 头节点实例化 data 设置成字符 c 变量");
            System.out.println("head = "+head);
        } else if (head.getData() == c) {
            System.out.println("链表中 data 值为 c 的节点位于头节点的位置，直接返回不做处理");
            return;
        } else {
            Node node = head;
            // 创建 preNode 指向 node 的前驱，方便后续链表满之后方便删除尾节点
            Node preNode = node;
            // 寻找找到数据 c 的前驱节点对象
            while (node.getNext() != null && node.getNext().getData() != c) {
                preNode = node;
                node = node.getNext();
            }
            System.out.println("试图寻找节点 data 值为字符 c 的前驱节点：");
            // 数据 c 不在链表中
            if (node.getNext() == null) {
                System.out.println("链表中不存在节点的 data 值为字符 c");
                System.out.println("n = "+n);
                // 缓存未满
                if (n != size) {
                    n ++;
                } else { // 缓存已满
                    System.out.println("缓存已满");
                    System.out.println("node = "+node);
                    preNode.setNext(null);
                }
                Node newNode = new Node(c);
                newNode.setNext(head);
                head = newNode;
            } else { // 数据 c 在链表当中
                System.out.println("找到链表中节点的 data  值为字符 c 的前驱节点 preNode = "+node);
                // 将对应节点的位置从链表中删除，并重新插入到 head 节点中
                node.setNext(node.getNext().getNext());
                Node newNode = new Node(c);
                newNode.setNext(head);
                head = newNode;
            }
        }
    }
}
