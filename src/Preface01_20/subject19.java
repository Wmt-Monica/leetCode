package Preface01_20;

/**
 * @Classname subject19
 * @Description TODO
 * @Date 2021/3/11 9:30
 * @Created by 翊
 *
 * 力扣第21题：合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class subject19 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        ListNode node1 = l1;
        ListNode node2 = l2;

        node1.next = new ListNode(2);
        node1 = node1.next;
        node1.next = new ListNode(4);

        node2.next = new ListNode(3);
        node2 = node2.next;
        node2.next = new ListNode(4);

//        while (l1 != null) {
//            System.out.print(l1.val+"\t");
//            l1 = l1.next;
//        }
//        System.out.println("\n=======================");
//        while (l2 != null) {
//            System.out.print(l2.val+"\t");
//            l2 = l2.next;
//        }

        ListNode result = new Solution().mergeTwoLists(l1,l2);
        while (result != null) {
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 创建最后合成链表对象
            ListNode result = new ListNode();

            // 判断两个链表的特殊情况，存在空对象情况
            if (l1 == null && l2 == null) {
                return null;
            }else if (l1 == null) {
                return l2;
            }else if (l2 == null) {
                return l1;
            }

            // 创建 node 节点指向 result 节点对象
            ListNode node = result;

            // 循环遍历链表条件，l1和l2任何一个都不为 null
            // 遍历两个链表相同长度的部分
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    node = node.next;
                    l1 = l1.next;
                }else {
                    node.next = new ListNode(l2.val);
                    node = node.next;
                    l2 = l2.next;
                }
            }

            // 将node接上l1和l2链表对象的剩余部分
            if (l1 != null) {
                node.next = l1;
            }else if (l2 != null) {
                node.next = l2;
            }

            // 返回结果链表的头节点下一个节点对象
            return result.next;
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
