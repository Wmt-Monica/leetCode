package google.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindMiddleNode
 * @Description TODO
 * @Date 2021/7/15 18:59
 * @Created by 翊
 * 寻找链表的中间节点
 */
public class FindMiddleNode {

    // 使用快慢指针的方式寻找中间节点
    // head 是链表中哨兵节点，指向头节点的前一个节点
    public List<Node> findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        List<Node> result = new ArrayList<>(2);
        // 如果链表为空，返回 null
        if (head == null || head.getNext() == null) {
            return null;
        } else {
            while (fast.getNext() != null) {
                if (fast.getNext().getNext() != null) {
                    fast = fast.getNext().getNext();
                    slow = slow.getNext();
                } else {
                    result.add(slow.getNext());
                    return result;
                }
            }
            // 偶数节点数，存在两个节点
            result.add(slow);
            result.add(slow.getNext());
            return result;
        }
    }
}
