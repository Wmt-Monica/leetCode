package Preface01_50;

/**
 * 两数相加：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表
 * 来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class subject1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 解法一：（比较的麻烦）
//            int num1 = method1(l1);
//            int num2 = method1(l2);
//            System.out.println(num1+"----"+num2);
//            System.out.println(num1+num2);
//            return method2(num1+num2);



            // 解法二：（普通的Java使用while()方法）
//            int carry = 0;  // 用于记录两个数字相加是否有进位
//            int sum = 0;  // 用于存储两个节点的数字的和
//            ListNode head = null;  // 创建返回结果的ListNode的头节点
//            ListNode node = null;  // 用于为头节点添加数据的辅助节点
//            while (l1 != null || l2 != null){
//                int num1 = l1 != null ? l1.val : 0;
//                int num2 = l2 != null ? l2.val : 0;
//                sum = num1 + num2 + carry;
//                if (head == null){
//                    head = node = new ListNode(sum % 10);
//                }else {
//                    node.next = new ListNode(sum % 10);
//                    node = node.next;
//                }
//                carry = sum / 10;  // 存储进位
//
//                // 因为存在两个ListNode的长度不一样，所以防止空节点对象引用而报错，所以加上判断
//                if (l1 != null){
//                    l1 = l1.next;  // 下移节点 l1
//                }
//                if (l2 != null){
//                    l2 = l2.next;  // 下一节点 l2
//                }
//
//                // 防止最大位数的两个数相加之后有进位，创建新的进位对象
//                if (carry > 0){
//                    node.next = new ListNode(carry);
//                }
//            }
//            return head;

            // 解法三：使用递归
            return method3(l1,l2,0);

        }

        public int method1(ListNode node){
            int num = node.val;
            int i =1;
            while (node.next != null){
                i *= 10;
                num += node.next.val*i;
                node = node.next;
            }
            return num;
        }

        public ListNode method2(int num){
            ListNode node = new ListNode(num % 10);
            ListNode step = node;
            while (num != 0){
                num /= 10;
                if (num != 0){
                    ListNode next = new ListNode(num % 10);
                    step.next = next;
                    step = step.next;
                }
            }
            return node;
        }

        public ListNode method3(ListNode l1,ListNode l2,int carry){
            // 如果两个ListNode为空来相加就返回null值
            if (l1 == null && l2 == null && carry == 0){
                return null;
            }
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            ListNode result = new ListNode(sum % 10);
            result.next = new ListNode(sum % 10);
            result.next = method3(l1 != null ? l1.next : null,l2 != null ? l2.next : null, sum / 10);
            return result;
        }

    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(3);
        ListNode num2 = new ListNode(8,num1);
        ListNode num3 = new ListNode(9,num2);
        ListNode num4 = new ListNode(3,num3);
        ListNode num5 = new ListNode(4,num4);
        ListNode l1 = new ListNode(2,num5);

        ListNode num6 = new ListNode(4);
        ListNode num7 = new ListNode(2,num6);
        ListNode num8 = new ListNode(1,num7);
        ListNode num9 = new ListNode(0,num8);
        ListNode num10 = new ListNode(6,num9);
        ListNode l2 = new ListNode(5,num10);

        ListNode result = new Solution().addTwoNumbers(l1,l2);
        while (result != null){
            System.out.print("'"+result.val+"' ");
            result = result.next;
        }

    }
}
