package Preface01_50;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class subject3 {
    public static void main(String[] args) {
        String s = "ababaabbcda";
        int length = new Solution().lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 解法一：使用集合的方法 时间复杂度 O(n^2)
//            Set<Character> str = new LinkedHashSet<>();  // 存储子串的Set集合
//            int end = 0;  // 截取字符串的结束位置
//            int length = 0;  // 储存无重复子串的长度
//            for (int start = 0; start < s.length(); start ++){
//                if (start != 0){
//                    str.remove(s.charAt(start-1));  // 每子串的起始位置向左移动的时候，子串集合删除前面的字符
//                }
//
//                // 如果，截取未超过字符串的长度，且后面一个字符在子串容器中未包含就添加进子串Set集合中
//                while (end < s.length() && !str.contains(s.charAt(end))){
//                    str.add(s.charAt(end));
//                    end ++;
//                }
//
//                length = Math.max(length,end-start);
//            }
//            return length;


            // 解法二：使用Map<V,K>的方式获取最长的无重复字符串，复杂度比上面的方法的时间复杂度小  O(n)
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0, start = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    System.out.print("1--->"+alpha);
                    System.out.println(" = "+map.get(alpha)+"\tstart = "+start+"\n");
                    start = Math.max(map.get(alpha), start);
                    System.out.println("2--->"+alpha+" = "+map.get(alpha)+"\tstart = "+start+"\n");
                }
                ans = Math.max(ans, end - start + 1);
                System.out.println("3--->put "+s.charAt(end)+"\tend = "+(end+1)+"\n");
                map.put(s.charAt(end), end + 1);
            }
            return ans;

        }
    }
}
