package Preface01_50;

/**
 * 回文数：
 *      判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class subject8 {
    public static void main(String[] args) {
        boolean flag = new Solution().isPalindrome(1234321);
        System.out.println(flag);
    }
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0){  // 由于负数的符号的缘故，负数肯定不是回文数
                return false;
            }
            int[] digit = new int[10];  // 因为 int 型数据的数据范围的数字位数为10位

            int i = 0;
            while (x > 0){
                digit[i++] = x % 10;
                x /= 10;
            }
            i --;
            for (int j = 0; j < i; j ++){
                System.out.println("digit[j] = "+digit[j]+"\tdigit[i] = "+digit[i]);
                if (digit[j] != digit[i]){
                    return false;
                }
                i --;
            }
            return true;
        }
    }
}
