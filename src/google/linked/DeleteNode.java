package google.linked;

/**
 * @Classname DeleteNode
 * @Description TODO
 * @Date 2021/7/15 17:29
 * @Created by 翊
 * 删除链表中倒数第 k 个节点
 */
public class DeleteNode {

    // 删除倒数第 k 个节点
    public Node deleteNode(Node head, int k) {
        Node node = head;
        // 首选获取该链表中长度
        int size = 0;
        while (node.getNext() != null) {
            node = node.getNext();
            size ++;
        }
        if (k > size) {
            System.out.println("k 超出链表长度限制");
            return head;
        } else {
            // 找到倒数第 k 个节点的前驱节点
            int i = size-k;
            node = head;
            while (i > 0) {
                node = node.getNext();
                i --;
            }
            node.setNext(node.getNext().getNext());
        }
        return head;
    }
}
