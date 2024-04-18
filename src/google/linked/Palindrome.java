package google.linked;

import java.util.Random;

/**
 * @Classname Palindrome
 * @Description TODO
 * @Date 2021/7/14 16:20
 * @Created by 翊
 * 单链表上的字符串判断是否为回文字符串
 */
public class Palindrome {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Palindrome(Node head) {
        this.head = head;
    }

    // 根据字符串中的字符生成指定的链表
    public void createLinked(String s) {
        // 假如 s == "" 空字符串，直接返回
        if (s.equals("")) {
            return;
        }
        Node node = head;
        node.setData(s.charAt(0));
        for (int i = 1; i < s.length(); i ++) {
            node.setNext(new Node());
            node.getNext().setData(s.charAt(i));
            node = node.getNext();
        }
        node = head;
        while (node != null) {
            System.out.print(node.getData()+"\t");
            node = node.getNext();
        }
    }

    // 随机生成单链表
    public void createLinked(int n) {
        // 创建随机数，初始化链表
        Random random = new Random();
        Node node = head;
        node.setData((char)(random.nextInt(10)+'a'));
        for (int i = 1; i < n; i ++) {
            node.setNext(new Node());
            node.getNext().setData((char)(random.nextInt(10)+'a'));
            node = node.getNext();
        }
        node = head;
        while (node != null) {
            System.out.print(node.getData()+"\t");
            node = node.getNext();
        }
    }

    /**
     * 给出链表头节点 head 判断该链表中的字符串是否为一个回文字符串
     * 时间复杂度为 O(n^2)
     * @param head
     * @return
     */
    public boolean judge(Node head) {

        if (head == null || head.getNext() == null) {
            return true;
        } else {
            // 创建链表的头节点和尾节点指针
            Node first = head;
            Node last = head;
            // 将 last 指针循环遍历链表的最后
            while (last.getNext() != null) {
                last = last.getNext();
            }

            while (true) {
                if (first.getData() != last.getData()) {
                    return false;
                }
                if (first.getNext() == last || first == last) {
                    return true;
                }
                first = first.getNext();
                last = findPreNode(head,last);
            }
        }
    }

    // 给出链表头节点 head 和所查找的节点对象 node，返回该节点对象的前一个节点对象
    public Node findPreNode(Node head, Node node) {
        // 创建 findNode 指向头节点 head
        Node findNode = head;
        // 如果查找的 node == head，那么其头结点返回 null
        if (node == head) {
            return null;
        } else {
            // 当 findNode 不是尾节点的，下移 findNode,直至遍历到 node 的前驱节点
            while (findNode.getNext() != null && findNode.getNext() != node) {
                findNode = findNode.getNext();
            }
            // 当 findNode == null 说明没有查找到 node 的前驱节点
            if (findNode.getNext() == null) {
                return null;
            }
        }
        return findNode;
    }

}
