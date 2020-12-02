package Preface01_50;

import java.util.*;

/**
 * 力扣题库 15 ：
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class subject13 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> list = new Solution().threeSum(nums);
        System.out.println(list);
    }
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 解法一：暴力匹配解法
             */
//            List<List<Integer>> result = new ArrayList<>();
//            for (int i = 0; i < nums.length-2; i ++){
//                for (int j = i+1; j < nums.length-1; j ++){
//                    for (int k = j+1; k < nums.length; k ++){
//                        if (nums[i]+nums[j]+nums[k] == 0){
//                            List list = new ArrayList();
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            Collections.sort(list);  // 将 list 集合进行排序，方便后面判断是否有重复的数字集合
//                            if (!result.contains(list)){
//                                result.add(list);
//                            }
//                        }
//                    }
//                }
//            }
//            return result;

            /**
             * 解法二：排序 + 循环 + 双指针
             */
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for (int first = 0; first < n; first ++) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                // 枚举 b
                for (int second = first + 1; second < third; second ++) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] + nums[first] > 0) {
                        third --;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    // if (second == third) {
                    //     break;
                    // }
                    if (second != third && nums[second] + nums[third] + nums[first] == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
}
