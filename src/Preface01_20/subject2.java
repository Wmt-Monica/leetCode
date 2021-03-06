package Preface01_20;

/**
 * 两数之和：
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class subject2 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 7, 15};
        int target = 9;
        Solution test = new Solution();
        int[] result = test.twoSum(nums,target);
        System.out.println("nums["+result[0]+"] + nums["+result[1]+"] = "+"target");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++){
            for (int j = 1; j < nums.length; j ++){
                if (i != j && nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}