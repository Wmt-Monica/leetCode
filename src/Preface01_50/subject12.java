package Preface01_50;

/**
 * 力扣题库 14 ：
 * 最长公共前缀:
 * 说明：编写一个函数来查找字符串数组中的最长公共前缀。
 *      如果不存在公共前缀，返回空字符串 ""
 * 注意：所有输入只包含小写字母 a-z
 */
public class subject12 {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flo"};
        String result = new Solution().longestCommonPrefix(str);
        System.out.println(result);
    }
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0){  // 考虑当传入的字符串数组中无数据时就返回空字符串
                return "";
            }
            // 首先获取字符串数组中的最短的字符长度
            int minStrLength = strs[0].length();
            for (String s : strs){
                minStrLength = Math.min(minStrLength,s.length());
            }
            int start = 0;
            StringBuffer result = new StringBuffer();
            while (start < minStrLength){
                char c = strs[0].charAt(start);  // 获取当前start位置的第一个字符串的首字符
                for (int i = 1; i < strs.length; i ++){
                    if (c != strs[i].charAt(start)){
                        return result.toString();
                    }
                }
                start ++;
                result.append(c);
            }
            return result.toString();
        }
    }
}
