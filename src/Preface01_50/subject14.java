package Preface01_50;

import java.util.Arrays;

/**
 * 力扣题库 16 ：
 * 最接近的三数之和
 * 说明：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class subject14 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int result = new Solution().threeSumClosest(nums,target);
        System.out.println(result);
    }
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums.length < 3){  // 如果给的数组中的数字个数不足三个集返回0
                return 0;
            }
            Arrays.sort(nums);  // 将nums数组从小到大排好序

            int first;
            int second;
            int third;
            int result = Integer.MAX_VALUE;  // 为了防止用到result时是空值，先初始化赋值Integer的最大值
            for (first = 0; first < nums.length; first ++){
                // 保证在指针移动的过程遇到与前一个相同的值就结束本次循环
                if (first != 0 && nums[first] == nums[first-1]){
                    continue;
                }
                second = first+1;
                third = nums.length-1;
                if (first == 0){
                    result = nums[first]+nums[second]+nums[third];
                }
                while (second < third){
                    int sum = nums[first]+nums[second]+nums[third];
                    if (Math.abs(sum-target) < Math.abs(result-target)){
                        result = sum;
                    }
                    if (sum == target){  // 如果找到了数组中三个数相加等于target就直接返回
                        return sum;
                    }
                    if (sum > target){  // 如果三个数的总值大于目标数 target 就向前移动 third 指针的位置
                        int otherThird = third-1;
                        while (otherThird > second && nums[otherThird] == nums[third]){
                            -- otherThird;
                        }
                        third = otherThird;
                    }
                    if (sum < target){  //如果三个数的总值小于目标数 target 就向后移动 second 指针位置
                        int otherSecond = second+1;
                        while (otherSecond < third && nums[otherSecond] == nums[second]){
                            ++ otherSecond;
                        }
                        second = otherSecond;
                    }
                }
            }
            return result;
        }
    }
}
