package Preface01_20;
/**
 * 整数反转:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 *      假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 *      请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class subject6 {
    public static void main(String[] args) {
        int result = new Solution().reverse(12345);
        System.out.println(result);
    }
    static class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0){
                int pop = x % 10;
                // 每次对结果的 result 添加下一位数字的时候就要对下一步步骤之后是否超过 int 数据类型的存储范围
                if (result> Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > 7)){  // 2^31-1的个位为7
                    return 0;
                }
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < -8)){  //-2^31-1的个位为-8
                    return 0;
                }
                result = result * 10 + pop;
                x /= 10;
            }
            return result;
        }
    }
}
