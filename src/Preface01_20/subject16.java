package Preface01_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname subject16
 * @Description TODO
 * @Date 2021/3/7 15:23
 * @Created by 翊
 * 力扣题库18：
 *      给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素
 *      a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *      注意：答案中不可以包含重复的四元组。
 */
public class subject16 {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {1,0,-1,0,-2,2};
        int  target = 0;
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        System.out.println(result);
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) throws InterruptedException {
                List<List<Integer>> results = new ArrayList<>();
                if (nums == null || nums.length < 4) {
                    return results;
                }
                int numsCount = nums.length;
                Arrays.sort(nums);
                for (int i = 0; i < numsCount-3; i ++) {
                    if (i > 0 && nums[i] == nums[i-1]) {
                        continue;
                    }
                    if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                        break;
                    }
                    if (nums[i] + nums[numsCount-1] + nums[numsCount-2] + nums[numsCount-3] < target) {
                        continue;
                    }
                    for (int j = i+1; j < numsCount-2; j ++) {
                        if (j > i+1 && nums[j] == nums[j-1]) {
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                            break;
                        }
                        if (nums[i] + nums[j] + nums[numsCount-1] + nums[numsCount-2] < target) {
                            continue;
                        }
                        int left = j+1;
                        int right = numsCount-1;
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left+1]) {
                                    left ++;
                                }
                                left++;
                                while (right > left && nums[right] == nums[right-1]) {
                                    right --;
                                }
                                right --;
                            }else if (sum < target) {
                                left ++;
                            }else {
                                right --;
                            }
                        }
                    }
                }
                return results;
        }
    }
}
