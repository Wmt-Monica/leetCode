package Preface01_50;

import java.util.Arrays;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class subject4 {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(new Solution().longestPalindrome(s));
    }

    static class Solution {

        /**
         * 功能：根据传入的字符串计算出最长的回文子串，并将该字串返回
         *
         * @param s 字符串
         * @return 返回字符串的最长回文子串
         */
        public String longestPalindrome(String s) {

           if (s.length() < 2){
               return s;
           }
            char[] ctr = s.toCharArray();
            int start;
            int end;
            int begin = 0;
            int maxLength = 1;

            /*
             * 解法一：暴力解法
             */
//           for (start = 0,begin = 0; start < s.length()-1; start ++){
//               for (end = start + 1; end < s.length(); end ++){
//
//                    if ((end - start + 1) > maxLength && judgePalindromeString(ctr,start,end)){
//                        // 如果此子串的长度大于 maxLength 且字符数组从下标为 start 到 end 截取的子串是回文序列
//                        // 就将回文子串头的下标从新赋值，其最长回文子串的长度重新赋值
//                        begin = start;
//                        maxLength = end - start + 1;
//                    }
//               }
//           }


            /*
             * 解法二：动态规划
             *
             * 实现方法：将字符串中的每一个字符为起始子串的开头 start ,在以 start 位置后的所有位置
             *          为 end 的子串是否为一个回文序列装入一个布尔二维数组中去，从中获取最长的子串
             *          的 start 和 end 下标
             */

            // 根据字符串的大小，创造一个行列都是字符串长度的布尔二维数组
            boolean[][] Palindrome = new boolean[s.length()][s.length()];
            // 将用来判断截取的各个子串是否为回文的动态布尔二维数组都赋值为 false
           for (int i = 0; i < Palindrome.length; i ++){
               Arrays.fill(Palindrome[i],false);
           }
            // 初始化：将当 end = start 时的子串都赋值为 true (当字串只有一个字符时一定为回文序列)
            for (int i = 0; i < Palindrome.length; i ++){
                Palindrome[i][i] = true;
            }

            for (end = 1; end < s.length(); end ++){
                for (start = 0; start < end; start ++){
                    if (ctr[start] != ctr[end]){
                        Palindrome[start][end] = false;
                    }else {
                        /*
                         *  当该子串的start 和 end 之间最多只有一个字符时，将以 start 开头
                         *  以 end 结尾的子串为回文子串，故将该子串在判断各个截取子串的布尔
                         *  二维数组的布尔值赋值为 true
                         */
                        if ((end - start) < 3){
                            Palindrome[start][end] = true;
                        }else {
                            /*
                             * 当该字串之间不止含有一个字符的时候，因为这两个字符相等，如果
                             * 这两个字符内的子串在判定是否为回文序列的布尔值也为 true，则
                             * 该以 start 开头和以 end 结尾的子串是回文子串，在布尔数组中赋
                             * 值为 true.
                             */
                            if (Palindrome[start+1][end-1]){
                                Palindrome[start][end] = true;
                            }
                        }
                    }

                    if (Palindrome[start][end] == true){
                        if (end - start + 1 > maxLength){
                            begin = start;
                            maxLength = end - start + 1;
                        }
                    }
                }
            }

            return s.substring(begin,begin+maxLength);

        }

        /**
         * 功能：根据传入的字符数组参数来判断该字符串是否为回文序列
         *
         * @param ctr 字符数组
         * @return 返回传入的字符数组是否为回文字符的布尔值
         */
        public boolean judgePalindromeString(char[] ctr,int start,int end){
            while (end > start){
                if (ctr[start] != ctr[end]){
                    return false;
                }
                end --;
                start ++;
            }
            return true;
        }
    }
}
