package google.linked;

/**
 * @Classname ReverseLinked
 * @Description TODO
 * @Date 2021/7/15 11:32
 * @Created by 翊
 * 反转链表
 */
public class ReverseLinked {

    // 头插法反转链表,其中 head 是哨兵节点，指向头节点的前一个
    public void headReverse(Node head) {
        // 当链表中为空或者只有一个节点时，直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        } else {
            // 创建节点指针分别指向第一个和第二个节点对象
            Node p = head.getNext();
            Node q = head.getNext().getNext();

            // 接下来是头插法反转链表的逻辑，之后查看请画图分析
            // 头插法，设置指针 p 指向原始链表的第一个头节点不要移动，
            // 依次遍历以下其他节点，插入到 p 节点的前一个也就是 head.next 的位置
            // 循环终止条件是 p.next 原始链表的头节点已经是反转后链表的最后一个节点
            while (p.getNext() != null) {
                p.setNext(q.getNext());
                q.setNext(head.getNext());
                head.setNext(q);
                q = p.getNext();
                // 打印反转该步骤的链表结果
//                print(head);
            }
        }
    }

    // 使用尾插法反转链表,其中 head 是链表中的哨兵节点指向头节点的前一个节点
    public void tailReverse(Node head) {
        // 如果链表为空或者只有一个节点时，直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        } else {
            // 创建 first 和 last 节点对象分别指向链表中的头节点和尾节点
            Node first = head.getNext();
            Node last = head.getNext();
            while (last.getNext() != null) {
                last = last.getNext();
            }
            // 可画图分析，
            // 尾插法，设置指针 last  指向原始链表的尾节点不要动，
            // 依次将节点从左至右遍历其他节点将其放置到 last.next 的位置
            // 循环终止条件是 head.next 哨兵节点的 next 域指向原始链表的尾节点 last
            while (head.getNext() != last) {
                head.setNext(first.getNext());
                first.setNext(last.getNext());
                last.setNext(first);
                first = head.getNext();
            }
        }
    }


    public void print(Node head) {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData()+"\t");
            node = node.getNext();
        }
        System.out.println();
    }

}
