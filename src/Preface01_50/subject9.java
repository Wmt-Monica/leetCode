package Preface01_50;

/**
 * 力扣题库 11 ：
 * 盛最多水的容器
 */
public class subject9 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int waterCapacity = new Solution().maxArea(height);
        System.out.println("最大容纳的水的体积："+waterCapacity);
    }
    static class Solution {
        public int maxArea(int[] height) {
            /**
             * 解法一：暴力匹配算的最大的容纳水容量的结果
             */

//            int maxWaterCapacity = 0;  // 创建变量用于存储容纳水的最大容量
//            for (int i = 0; i < height.length-1; i ++){
//                for (int j = i + 1; j < height.length; j ++){
//                    // 找到两个柱子最矮的那个柱子是最容纳水的最高高度在乘以两个柱子的相差的距离算的这连个柱子所能容乃的最大水容量
//                   int step = height[i] <= height[j] ? (j-i)*height[i] : (j-i)*height[j];
//                   maxWaterCapacity = maxWaterCapacity > step ? maxWaterCapacity : step;
//                }
//            }
//            return maxWaterCapacity;

            /**
             * 双指针法：创建两个变量用于指定各个柱子的下标
             *
             * 思想：两个柱子指针开始位于最左边和最右边的柱子，这两根柱子距离是最远的
             *      通过循环来寻找最大的水容量，两个两个柱子指针相互靠拢，移动两个指针
             *      中所指向的矮的柱子，因为两个柱子的距离在减小，同时最大的水容量取决
             *      于最矮的柱子高度，如果指向两个最矮的柱子不变，在移动指针时，不会找
             *      到比此时更大的水容量
             */
            int left = 0;  // 柱子的左指针
            int right = height.length-1;  // 柱子的右指针
            int maxWaterCapacity = 0;  // 最大的水容量
            while (left < right){  // 右指针在保证在左指针的右边
                int step = height[left] < height[right] ? (right-left)*height[left] : (right-left)*height[right];
                maxWaterCapacity = maxWaterCapacity > step ? maxWaterCapacity : step;
                if (height[left] < height[right]){
                    left ++;
                }else {
                    right --;
                }
            }
            return maxWaterCapacity;
        }
    }
}
