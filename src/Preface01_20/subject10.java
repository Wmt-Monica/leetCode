package Preface01_20;

/**
 * 力扣题库 12 ：
 * 整数转罗马数字
 */
public class subject10 {
    public static void main(String[] args) {
        String result = new Solution().intToRoman(4);
        System.out.println(result);
    }
    static class Solution {
        public String intToRoman(int num) {
            /**
             * 解法一：使用贪心算法，将所有的可能都放在列出，将最大的可能放在前面进行遍历，这样将贪心算法的优势使用出
             */
            /* 创建一个int型数组存储从大到小的对应的数字值
             * 在创建一个字符串数组存储相同下标对应的罗马数字字符串
             * 在创建一个 StringBuffer 对象用于罗马数字字符串的使用 append() 连接
             */
            int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] sign = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < value.length && num > 0; i ++){
                while (value[i] <= num){
                    num -= value[i];  // 将对应的大额数据减去，如果减去 num 仍然大于对应的 value[i] 的数据
                    result.append(sign[i]);
                }
            }
            return result.toString();
        }
    }
}
