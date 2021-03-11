package Preface01_20;

/**
 * @Classname subject17
 * @Description TODO
 * @Date 2021/3/9 18:40
 * @Created by 翊
 * 力扣第19题
 */
public class subject17 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 10; i ++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node = head;
        while (node.next != null) {
            System.out.print(node.val+"\t");
            node = node.next;
        }
        System.out.println("\n===========================");
        ListNode newHead = new Solution().removeNthFromEnd(head, 7);
        node = newHead;
        while (node.next != null) {
            System.out.print(node.val+"\t");
            node = node.next;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 创建头节点前一个节点对象
            ListNode dummy = new ListNode(0, head);
            // 获取链表的长度
            int length = getLength(head);
            // 创建头节点的前一个节点
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode ans = dummy.next;
            return ans;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
