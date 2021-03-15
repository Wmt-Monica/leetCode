package preface21_40;


/**
 * @Classname Subject23
 * @Description TODO
 * @Date 2021/3/15 15:05
 * @Created by 翊
 * 27. 移除元素
 *      给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 */
public class Subject23 {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = (int) (Math.random()*8)+1;
        }
        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
        int result = new Solution().removeElement(nums, 3);
        for (int i = 0; i < result; i ++) {
            System.out.print(nums[i]+"\t");
        }
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int i = 0;
            for (int j = 0; j < nums.length; j ++) {
                if (nums[j] != val) {
                    nums[i++] = nums[j];
                }
            }
            return i;
        }
    }
}
