package Preface01_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname subject18
 * @Description TODO
 * @Date 2021/3/11 8:45
 * @Created by 翊
 *
 * 力扣第20题：有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class subject18 {
    public static void main(String[] args) {
        String s =  "({([]{()})})";
        Boolean flag = new Solution().isValid(s);
        System.out.println(flag);
    }

    static class Solution {
        public boolean isValid(String s) {
            // 提前根据字符串的奇偶来判断是否为有效的括号字符串
            // 字符串长度为奇数直接返回 false
            if (s.length() % 2 == 1) {
                return false;
            }

            // 创建字符串对应的 HashMap() 对象
            // 将右括号添加到 map 中的 key 对象
            // 将左括号添加到 mao 中的 value 对象
            Map<Character, Character> map = new HashMap<>();
            map.put(')','(');
            map.put(']','[');
            map.put('}','{');

            // 创建临时存放左括号的栈对象
            Stack<Character> result = new Stack<>();

            for (int i = 0; i < s.length(); i ++) {
                // 获取字符串第 i 个字符对象 c
                Character c = s.charAt(i);

                // 如果此字符 c 是否为右括号字符
                if (map.containsKey(c)) {
                    // 如果获取到的字符右括号字符且栈中为空或者栈顶元素
                    // 不是 map 中对应 c 这个 key 对象的 value,直接返回 false
                    if (result.isEmpty() || result.peek() != map.get(c) ) {
                        return false;
                    }
                    // 栈顶元素对应获取到的 c 字符串,将栈顶元素删除
                    result.pop();
                }else {
                    // 获取到的元素为左括号元素字符
                    result.add(c);
                }
            }
            return result.isEmpty();
        }
    }

}
