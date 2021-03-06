package Preface01_20;

/**
 * Z字形变换
 *
 * 功能：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *      比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *      L   C   I   R
 *      E T O E S I I G
 *      E   D   H   N
 *      之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *      请你实现这个将字符串进行指定行数变换的函数：
 */
public class subject5 {
    public static void main(String[] args) {
        String s = new Solution().convert("0123456789012345678901234567890123456789",7);
        System.out.println(s);
    }
    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1){
                return s;
            }

            char[] ctr = s.toCharArray();
            boolean toDown = false;
            String[] str = new String[numRows];
            for (int i = 0; i < str.length; i ++){
                str[i] = "";
            }
            for (int i = 0,j = 0; i < ctr.length; i ++){
                str[j] += (ctr[i]);
                if (j == 0 || j == numRows-1){
                    toDown = !toDown;
                }
                j += toDown ? 1 : -1;
            }

            String result = "";
            for (int  i = 0; i < numRows; i ++){
                System.out.println(str[i]);
                result += str[i];
            }
            return result;
        }
    }
}
