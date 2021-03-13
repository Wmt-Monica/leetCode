package preface21_40;


/**
 * @Classname Subject21
 * @Description TODO
 * @Date 2021/3/12 10:09
 * @Created by 翊
 * 力扣第24题：两两交换链表中的节点
 *
 * 描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Subject21 {

    public static void main(String[] args) throws InterruptedException {
       ListNode head = new ListNode(1);
       ListNode node = head;
       for (int i = 2; i < 20; i ++) {
           node.next = new ListNode(i);
           node = node.next;
       }

       ListNode result = new Solution().swapPairs2(head);

       // 循环遍历交换后的链表
        while (result != null) {
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }

    static class Solution {
        // 迭代遍历链表进行交换
        public ListNode swapPairs(ListNode head) {
            // 如果该链表的头节点为 null,直接返回 null
            if (head == null) {
                return null;
                // 如果该链表的只有一个节点，直接返回这个头节点
            }else if (head.next == null) {
                return head;
            }else {
                // 提前存取交换链表后的头节点
                ListNode result = head.next;

                // 循环遍历交换前的链表结构
                ListNode n = head;
                while (n != null) {
                    System.out.print(n.val+"\t");
                    n = n.next;
                }
                System.out.println();

                // 创建一个节点，下一个节点指向链表的头节点
                ListNode reHead = new ListNode(0, head);

                // 循环俩俩接环节点的循环条件 先驱节点后面不足两个节点
                while (reHead.next.next != null) {
                    System.out.println("reHEad.next.next = "+reHead.next.next.val);
                    ListNode node = reHead.next.next;  // 提前存储要右节点
                    System.out.println("node = "+node.val);
                    reHead.next.next = node.next;  //  将左节点 next 指向右节点的 next
                    System.out.println("reHead.next.next = "+reHead.next.next.val);
                    node.next = reHead.next;  // 将右节点 next 指向左节点
                    System.out.println("node.next = "+node.next.val);
                    reHead.next = node;
                    System.out.println("reHead.next = "+reHead.next.val);
                    reHead = reHead.next.next;
                    System.out.println("reHead = "+reHead.val);
                    if(reHead.next == null) {
                        break;
                    }

                    ListNode n1 = result;
                    while (n1 != null) {
                        System.out.print(n1.val+"\t");
                        n1 = n1.next;
                    }
                    System.out.println();
                }

                return result;
            }
        }

        // 使用递归的方法进行链表上的交换
        public ListNode swapPairs2(ListNode head) {
            // 如果遍历到的节点为 null 或者该节点时最后一个节点就直接返回该节点
            if (head == null || head.next == null) {
                return head;
            }else {
                // 创建链表的两个节点之间的新的头节点
                ListNode newHead = head.next;
                // 将原先的头节点的next指向心头节点newHead的next
                head.next = swapPairs2(newHead.next);
                // 将新头节点newHead的next指向旧头节点head
                newHead.next = head;
                // 返回心头节点
                return newHead;
            }
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
