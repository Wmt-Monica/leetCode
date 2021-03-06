package Preface01_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname test
 * @Description TODO
 * @Date 2021/3/6 21:39
 * @Created by 翊
 */
public class subject15 {
    public static void main(String[] args) {
        String digits = "345";
        List result = new subject15.Solution().letterCombinations(digits);
        System.out.println(result);
    }
    static class Solution {
        public List<String> letterCombinations(String digits) {
            // 创建返回结果集 List<String> 对象
            List<String> results = new ArrayList<>();
            if (digits.equals("")) {
                return results;
            }

            // 创建电话机对应的 Map<Character, String> 对象
            Map<Character, String> phoneMap = new HashMap<>() {{
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }};

            backtrack(results, phoneMap, 0, digits, new StringBuffer());

            return results;  // 返回结果集对象
        }

        /**
         * 根据输入的电话拨号返回电话键对应字母的输入的结果集 List 对象
         * @param results 传入的结果集 List<String> 对象
         * @param phoneMap 电话机对应数字和字母集 Map<Character, String> 对象
         * @param digitIndex 对应回溯遍历的号码数字的标识序号位置
         * @param digits 对应输入的数字字符串
         * @param result 用于存储其中一个结果的 StringBuffer 对象
         */
        public void backtrack(List<String> results, Map<Character,String> phoneMap, int digitIndex, String digits, StringBuffer result) {
            // 当每个对应的结果到了最后一个数字的字母时，就将其结果添加到最后的结果集 results 对象中去
            if (digitIndex == digits.length()) {
                results.add(result.toString());
            }else {
                // 获取当前 digitIndex 位置的字母字符串
                String letters = phoneMap.get(digits.charAt(digitIndex));
                // 遍历当前字母字符串的所有字母
                for (int i = 0; i < letters.length(); i ++) {
                    result.append(letters.charAt(i));  // 将对应的字母添加到结果 result 对象
                    // 使用递归到号码数字的下一位
                    backtrack(results, phoneMap, digitIndex+1, digits, result);
                    // 当一直递归到最后一个数字的字母，在回溯到上一个数字对应的字母前
                    // 将结果对象删除当前数字对应字母的字母字符串
                    result.deleteCharAt(digitIndex);
                }
            }
        }
    }
}
