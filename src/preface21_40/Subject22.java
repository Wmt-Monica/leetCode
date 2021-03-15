package preface21_40;

import java.util.Arrays;

/**
 * @Classname Subject22
 * @Description TODO
 * @Date 2021/3/15 14:39
 * @Created by 翊
 * 26. 删除排序数组中的重复项
 * 描述:
 *      给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Subject22 {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = (int) (Math.random()*10)+1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
        int result = new Solution().removeDuplicates(nums);
        for (int i = 0; i < result-1; i ++) {
            System.out.print(nums[i]+"\t");
        }
        System.out.println("\nlength = "+result);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int q = 1;
            int firstValue = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                if (nums[i] != firstValue) {
                    nums[q] = nums[i];
                    firstValue = nums[q];
                    q ++;
                }
            }
            return q;
        }
    }
}
