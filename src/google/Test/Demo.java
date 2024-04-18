package google.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2022/4/14 21:54
 * @Created by 翊
 */
public class Demo {

    Map<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Demo demo = new Demo();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        int[][] ops = {{0,2,2},{1,1,5},{0,4,5},{1,5,7}};
        int count = demo.getNumber(root, ops);
        System.out.println("count = "+count);
    }

    public int getNumber(TreeNode root, int[][] ops) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < ops.length; i ++) {
            if (ops[i][0] == 1) {
                min = Math.min(min, ops[i][1]);
                max = Math.max(max, ops[i][2]);
            }
        }
        System.out.println("min = " +min);
        System.out.println("max = " + max);
        helper(root, min, max);
        int count = 0;
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) count ++;
        }
        return count;
    }

    public void helper(TreeNode node, int x, int y) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println("1 - node = "+node.val);
            if (node.val >= x && node.val <= y) {
                System.out.println("node = " +node.val);
                map.put(node, 1);
                if (node.val > x && node.left != null) stack.push(node.left);
                if (node.val < y && node.right != null) stack.push(node.right);
            } else if (x < node.val && node.left != null) {
                stack.push(node.left);
            } else if (y > node.val && node.right != null) {
                stack.push(node.right);
            }
        }
        System.out.println("====================");
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
