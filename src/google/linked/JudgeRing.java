package google.linked;

import java.util.Map;

/**
 * @Classname DetectionRing
 * @Description TODO
 * @Date 2021/7/15 13:33
 * @Created by 翊
 * 检测链表中是否存在环
 */
public class JudgeRing {
    // 方法一：使用快慢指针法，诺不存在环，两个指针先后完成遍历链表的，
    // 如果成环，两指针相遇即存在环结构，head 是哨兵节点，指向头节点的前一个节点
    public boolean judge(Node head) {
        if (head == null || head.getNext() == null) {
            System.out.println("该链表为空，不存在环结构");
            return false;
        }
        // 创建快慢指针初始均指向 head
        Node fast = head;
        Node slow = head;
        while (fast.getNext() != null || fast.getNext().getNext() != null) {
            // 快指针移动两步，慢指针移动一步
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            System.out.println("fast = "+fast);
            System.out.println("slow = "+slow);
            // 当快慢指针相遇说明链表中存在环结构
            if (fast == slow) {
                System.out.println("fast == slow,存在环结构");
                return true;
            }
        }
        return false;
    }

}
