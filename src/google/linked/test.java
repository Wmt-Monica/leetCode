package google.linked;


import java.util.List;
import java.util.Random;

/**
 * @Classname test
 * @Description TODO
 * @Date 2021/7/14 19:20
 * @Created by 翊
 */
public class test {

//    // 单链表中判断回文字符串
//    @Test
//    public void PalindromeTest() {
//        Palindrome palindrome = new Palindrome(new Node());
//        palindrome.createLinked("abbcdaabcbaadcbba");
//        Boolean flag = palindrome.judge(palindrome.getHead());
//        System.out.println("\nflag = " + flag);
//    }
//
//    // 实现 LRU(最久未使用) 单链表实现
//    @Test
//    public void LRUTest() {
//        LRU lru = new LRU(4,"12245643241");
//        lru.cache();
//    }
//
//    // 实现链表的头插法和尾插法
//    @Test
//    public void LinkedInsertTest() {
//        LinkedInsert linkedInsert = new LinkedInsert();
//        Random random = new Random();
//        for (int i = 0; i < 20; i ++) {
//            Node newNode = new Node((char) (random.nextInt(10)+'a'));
//            System.out.println("NewNode = "+newNode);
//            if (i % 2 == 0) {
//                // 偶数次数使用头插法
//                linkedInsert.headInsertion(newNode);
//            } else {
//                // 奇数次数使用尾插法
//                linkedInsert.tailInsertion(newNode);
//            }
//            linkedInsert.traverse(linkedInsert.getHead());
//            System.out.println();
//        }
//    }
//
//    // 使用头插法反转链表
//    @Test
//    public void reverseLinkedTest1() {
//        ReverseLinked reverseLinked = new ReverseLinked();
//        // 创建一个有哨兵节点的链表对象
//        LinkedInsert linkedInsert = new LinkedInsert();
//        Random random = new Random();
//        for (int i = 0; i < 20; i ++) {
//            Node newNode = new Node((char) (random.nextInt(10)+'a'));
//            linkedInsert.headInsertion(newNode);
//        }
//        // 打印创建好的链表
//        reverseLinked.print(linkedInsert.getHead());
//        // 反转链表
//        reverseLinked.headReverse(linkedInsert.getHead());
//        // 打印反转后的链表
//        reverseLinked.print(linkedInsert.getHead());
//    }
//
//    // 使用尾插法反转链表
//    @Test
//    public void reverseLinkedTest2() {
//        ReverseLinked reverseLinked = new ReverseLinked();
//        // 创建一个有哨兵节点的链表对象
//        LinkedInsert linkedInsert = new LinkedInsert();
//        Random random = new Random();
//        for (int i = 0; i < 20; i ++) {
//            Node newNode = new Node((char) (random.nextInt(10)+'a'));
//            linkedInsert.headInsertion(newNode);
//        }
//        // 打印创建好的链表
//        reverseLinked.print(linkedInsert.getHead());
//        // 反转链表
//        reverseLinked.tailReverse(linkedInsert.getHead());
//        // 打印反转后的链表
//        reverseLinked.print(linkedInsert.getHead());
//    }
//
//    @Test
//    public void judgeRingTest() {
//        // 创建一个存在环结构的链表
//        /*
//                         g <- f <- e
//                         |         |
//                         |         |
//            head -> a -> b -> c -> d
//         */
//        Node head = new Node();
//        Node node = head;
//        Node ring = new Node('b');
//        node.setNext(new Node('a'));
//        node = node.getNext();
//        node.setNext(ring);
//        node = node.getNext();
//        node.setNext(new Node('c'));
//        node = node.getNext();
//        node.setNext(new Node('d'));
//        node = node.getNext();
//        node.setNext(new Node('e'));
//        node = node.getNext();
//        node.setNext(new Node('f'));
//        node = node.getNext();
//        node.setNext(new Node('g'));
//        node = node.getNext();
//        node.setNext(ring);
//        // 判断链表是否存在环结构
//        System.out.println("该链表是否存在环结构 = "+new JudgeRing().judge(head));
//    }
//
//    // 链表的有序插入方法与合并两个有序的链表
//    @Test
//    public void orderInsertTest() throws InterruptedException {
//        OrderInsert linked1 = new OrderInsert();
//        OrderInsert linked2 = new OrderInsert();
//        Random random = new Random();
//        // 有序插入随机生成的节点
//        for (int i = 0; i < 10; i ++) {
//            Node addNode1 = new Node((char) (random.nextInt(26)+'a'));
//            Node addNode2 = new Node((char) (random.nextInt(26)+'a'));
//            linked1.orderInsert(addNode1);
//            linked2.orderInsert(addNode2);
//        }
//        // 打印链表
//        linked1.print(linked1.getHead());
//        linked2.print(linked2.getHead());
//        Node newNode = linked1.merge(linked1.getHead(), linked2.getHead());
//        linked1.print(newNode);
//        linked1.print(linked1.getHead());
//        linked1.print(linked2.getHead());
//    }
//
//    // 删除倒数第 k 个节点后的链表
//    @Test
//    public void deleteNodeTest() {
//        OrderInsert linked = new OrderInsert();
//        Random random = new Random();
//        // 有序插入随机生成的节点
//        for (int i = 0; i < 10; i ++) {
//            Node addNode1 = new Node((char) (random.nextInt(26)+'a'));
//            linked.orderInsert(addNode1);
//        }
//        // 打印链表
//        linked.print(linked.getHead());
//        // 删除第 k 个
//        Node node = new DeleteNode().deleteNode(linked.getHead(), 6);
//        System.out.println("删除倒数第 6 个节点后的链表");
//        linked.print(node);
//    }
//
//    // 寻找中间节点对象
//    @Test
//    public void findMiddleNodeTest() {
//        // 创建一个奇数节点数的链表对象和一个偶数节点数的链表对象
//        OrderInsert linked1 = new OrderInsert();
//        OrderInsert linked2 = new OrderInsert();
//        Random random = new Random();
//        // 有序插入随机生成的节点
//        for (int i = 0; i < 10; i ++) {
//            Node addNode1 = new Node((char) (random.nextInt(26)+'a'));
//            linked1.orderInsert(addNode1);
//        }
//        for (int i = 0; i < 11; i ++) {
//            Node addNode2 = new Node((char) (random.nextInt(26)+'a'));
//            linked2.orderInsert(addNode2);
//        }
//        // 打印链表
//        linked1.print(linked1.getHead());
//        linked2.print(linked2.getHead());
//        FindMiddleNode findMiddleNode = new FindMiddleNode();
//        List<Node> middleNode1 = findMiddleNode.findMiddleNode(linked1.getHead());
//        List<Node> middleNode2 = findMiddleNode.findMiddleNode(linked2.getHead());
//        System.out.println("middleNode1 = "+middleNode1);
//        System.out.println("middleNode2 = "+middleNode2);
//    }

}
