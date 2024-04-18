package preface21_40;

/**
 * @Classname Subject25
 * @Description TODO
 * @Date 2021/3/15 16:14
 * @Created by 翊
 * 29. 两数相除
 *      给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *      返回被除数 dividend 除以除数 divisor 得到的商。
 *      整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Subject25 {
    public static void main(String[] args) {

        int dividend = -2147483648;
        int divisor = 4;
        int result = new Solution().divide(dividend, divisor);
        System.out.println("result = "+result);
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }else if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean q = false;
            boolean p = false;
            if (dividend < 0) {
                q = true;
                dividend = -dividend;
            }
            if (divisor < 0) {
                p = true;
                divisor = -divisor;
            }

            int result = 0;
            while (dividend - divisor >= 0) {
                dividend -= divisor;
                result ++;
            }

            if ((q && p) || (!q && !p)) {
                return result;
            } else {
                return -result;
            }
        }
    }
}
