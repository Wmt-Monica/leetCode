package preface21_40;


/**
 * @Classname Subject24
 * @Description TODO
 * @Date 2021/3/15 15:18
 * @Created by 翊
 * 28. 实现 strStr()
 *      实现 strStr() 函数。
 *      给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出
 *      needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class Subject24 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int result = new Solution().strStr(haystack, needle);
        System.out.println(result);
        String s = haystack.substring(3,5);
        System.out.println("s = "+s);
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int length1 = haystack.length();
            int length2 = needle.length();
            for (int i = 0; i < length1-length2+1; i ++) {
                if (haystack.substring(i, i + length2).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        public int strStr(String haystack, String needle) {
            int m = haystack.length(), n = needle.length();
            if (n == 0) return 0;
            for (int i = 0; i <= m - n; i++) {
                for (int j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    if (j == n - 1) return i;
                }
            }
            return -1;
        }
    }
}
