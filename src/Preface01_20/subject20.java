package Preface01_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname subject20
 * @Description TODO
 * @Date 2021/3/11 9:58
 * @Created by 翊
 *
 * 力扣第22题：括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class subject20 {
    public static void main(String[] args) {
        List<String> result;
        result = new Solution2().generateParenthesis(3);
        System.out.println("==================");
        System.out.println(result);
        System.out.println(result.size());
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            // 创建结果 List<String> 对象
            List<String> result = new ArrayList<>();
            method(new StringBuffer(), result, n*2);
            return result;
        }

        // 使用回溯算法来对三对括号进行所有的拼凑
        public void method(StringBuffer s, List<String> result, int n) {
            if (n == 0) {
                // 当到达了回溯的头判断获取的拼凑括号组合和否符合要求在选择性添加入result结果List对象
                if (method2(s.toString())) {
                    result.add(s.toString());
                }
            }else {
                String brackets = "()";  // 括号字符串
                for (int i = 0; i < brackets.length(); i ++) {
                    s.append(brackets.charAt(i));
                    method(s, result, n-1);
                    s.deleteCharAt(s.length()-1);
                }
            }
        }

        // 创建方法来判断该三对括号的组合是否符合
        public Boolean method2(String s) {
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                       return false;
                    }
                    stack.pop();
                }else {
                    stack.add(c);
                }
            }
            return stack.isEmpty();
        }
    }

    static class Solution2 {
        public List<String> generateParenthesis(int n) {
            // 创建结果 List<String> 对象
            List<String> result = new ArrayList<>();
            method(result, new StringBuffer(), 0, 0, n);
            return result;
        }

        /**
         * 使用回溯算法进行有效括号的拼凑
         * @param result 存放所有有效括号字符串的结果集
         * @param s 用于拼凑有效括号的StringBuffer对象
         * @param open 记录左括号的个数
         * @param close 记录右括号的个数
         * @param n 所要拼凑的括号对数
         */
        public void method(List<String> result, StringBuffer s, int open, int close, int n) {
            if (s.length() == n*2) {
                result.add(s.toString());
                return;
            }else {
                // 进行括号的填充的时候，先要对左括号进行回溯
                if (open < n) {
                    s.append('(');
                    method(result, s, open+1, close, n);
                    s.deleteCharAt(s.length()-1);
                }
                // 如果右括号的个数小于左括号就进行右括号的字符串连接
                if (close < open) {
                    s.append(')');
                    method(result, s, open, close+1, n);
                    s.deleteCharAt(s.length()-1);
                }
            }
        }
    }
}
