package Preface01_50;

/**
 * 力扣题库 9 ：
 * 回文数：
 *      判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class subject8 {
    public static void main(String[] args) {
        boolean flag = new Solution().isPalindrome(10);
        System.out.println(flag);
    }
    static class Solution {
        public boolean isPalindrome(int x) {
            /**
             * 解法一：将所有的数字存入一个int型数组当中去，然后从两头获取数字来进行对比判断是否相等
             */
//            if (x < 0){  // 由于负数的符号的缘故，负数肯定不是回文数
//                return false;
//            }
//            int[] digit = new int[10];  // 因为 int 型数据的数据范围的数字位数为10位
//
//            int i = 0;
//            while (x > 0){
//                digit[i++] = x % 10;
//                x /= 10;
//            }
//            i --;
//            for (int j = 0; j < i; j ++){
//                System.out.println("digit[j] = "+digit[j]+"\tdigit[i] = "+digit[i]);
//                if (digit[j] != digit[i]){
//                    return false;
//                }
//                i --;
//            }
//            return true;

            /**
             * 解法二：将数字反转一半，将剩下的数字的高位的左半部分与低位的右半部分判断是否相等
             */
            if (x < 0){  // 由于负数的符号约束，负数的整数肯定不是回文数
                return false;
            }else if (x % 10 == 0 && x != 0){  // 如果数字的末尾是数字0，但是该数字不是0，那么该数也不是回文数
                return false;
            }
            int rightDigit = 0;
            while (x > rightDigit){
                rightDigit = rightDigit * 10 + x % 10;
                x /= 10;
            }

            // 前面的是数字的位数为偶数的情况，后面是数字的位数值奇数的情况，将中间的数字除去10再来进行判断
            return x == rightDigit || x == rightDigit/10;
        }
    }
}
