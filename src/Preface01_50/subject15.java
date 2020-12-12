package Preface01_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣题库 17 ：电话号码的字母组合
 * 说明：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class subject15 {
    public static void main(String[] args) {
        String digits = "345";
        List result = new Solution().letterCombinations(digits);
    }
    static class Solution {
        public List<String> letterCombinations(String digits) {
           int[] nums = new int[digits.length()];  // 创建int数组存放字符串参数的有效数字

           for (int i = 0; i < digits.length(); i ++){  // 将参数字符串中的有效数据添加入对应的int数组中
               nums[i] = digits.charAt(i)-'0';
           }

           // 创建每个按键对应的字母数组，每一行代表按键数字
           char[][] buttonStr = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
                        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

           List<String> result = new ArrayList<>();  // 创建存放String的List集合存放最后拼凑字符的集合
           int i = nums.length-1;
        }

        public String method(int[] nums,char[][] buttonStr,int i) {
            String
            for (int j = 0; j < nums.length; j ++){
                if (j == i){

                }
            }
        }
    }
}
