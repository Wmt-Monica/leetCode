package Preface01_20;


/**
 * 字符串转换整数
 *      注意：1.是有效的数组字字符串
 *           2.如果结果超过Integer的数据范围就以 MAX_VALUE 或者 MIN_VALUE 返回
 *
 */
public class subject7 {
    public static void main(String[] args) {
        int result = new Solution().myAtoi("   -42");
        System.out.println(result);
    }
    static class Solution {
        public int myAtoi(String str) {
            str = str.trim();  // 将原先的参数字符串去除两边的空格

            // 如果原先的字符串本身全部是由空格组成或者第一个非空格字符串不是数字且不是正负号就返回0
            if (str.length() == 0 ||
                    (!Character.isDigit(str.charAt(0)) &&
                            str.charAt(0) != '+' && str.charAt(0) != '-')){
                return 0;
            }
            int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;  // 如果第一个字符是符号就从字符串的 1 下标开始循环获取数字
            int result = 0;  // 存储最后 int 型数字结果的变量
            boolean sign = (str.charAt(0) == '-') ? true : false;
            while (i < str.length() && Character.isDigit(str.charAt(i))){  // 如果获取字符串未超过字符串的长度且下一个字符是可转换的字符型
                int temp = ((sign ? Integer.MIN_VALUE : Integer.MIN_VALUE+1) + str.charAt(i)-'0')/10;
                if (temp > result){
                    return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                // 获取字符串下一个是数字的字符串的int型数字，同时使得 i++,下移字符串的下一位字符的下标位置
                result = result * 10 - (str.charAt(i++)-'0');  // 获得一个结果的负数
            }
            return sign ? result : -result;
        }
    }
}
