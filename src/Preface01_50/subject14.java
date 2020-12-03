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
            for (int i = 0; i < nums.length; i ++){
                System.out.print(nums[i]+ "\t");
            }
            System.out.println("\n");
            int first = 0;
            int second;
            int third = nums.length-1;
            int minSum = nums[0]+nums[1]+nums[nums.length-1]-target;
            for (second = first+1; second < third;){
                while (second < third && nums[first]+nums[second]+nums[third] > target){
                    System.out.println("--1--\t"+"num["+first+"] = "+nums[first]+" nums["+second+"] = "+
                            nums[second]+" nums[third] = "+nums[third]);
                    third --;
                }
                while (second < third && nums[first]+nums[second]+nums[third] < target){
                    System.out.println("--2--\t"+"num["+first+"] = "+nums[first]+" nums["+second+"] = "+
                            nums[second]+" nums["+third+"] = "+nums[third]);
                    second ++;
                }
                if (second == third){
                    if (nums[first]+nums[second]+nums[third] > target || third == nums.length-1){
                        -- second;
                        return nums[first]+nums[second]+nums[third];
                    }else if (nums[first]+nums[second]+nums[third] < target){
                        while (first < second && nums[first]+nums[second]+nums[third] < target){
                            System.out.println("--3--\t"+"num["+first+"] = "+nums[first]+" nums["+second+"] = "+
                                    nums[second]+" nums["+third+"] = "+nums[third]);
                            ++ first;
                        }
                        if (first == second){
                            -- first;
                        }
                        return nums[first]+nums[second]+nums[third];
                    }
                }else {
                    System.out.println("target = "+target+"\t --3--"+nums[first]+nums[second]+nums[third]);
                    if (Math.abs(nums[first]+nums[second]+nums[third] - target) < minSum){
                        minSum = nums[first]+nums[second]+nums[third];
                    }
                    break;
                }
            }
            return minSum;
        }
    }
}
