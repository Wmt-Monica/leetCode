package google.stack;

import java.util.Arrays;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2021/7/15 21:16
 * @Created by 翊
 */
public class test {

    public static void main(String[] args) {
//        String needle = "abcabcabcabc";
//        String haystack = "abc";
//        int i = strStr(haystack, needle);
//        System.out.println(i);
        System.out.println(add(10));
    }

    public static int add(int n) {
        int sum = n;
        if (n == 1) return sum;
        else sum += add(n - 1);
        return sum;
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int j = 0;
        for (int i = 0; i < haystack.length(); i ++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                System.out.println("j = "+ j);
                System.out.println("haystack.charAt(i) = " +haystack.charAt(i));
                System.out.println("needle.charAt(j) = " +needle.charAt(j));
                j = next[j - 1];
                System.out.println("j = "+ j);
            }
            if (haystack.charAt(i) == needle.charAt(j)) j ++;
            System.out.println("j = "+ j);
            if (j == needle.length()) return i - j + 1;
        }
        return -1;
    }

    public static int[] getNext(String needle) {
        int n = needle.length();
        int[] next = new int[n];
        int j = 0;
        for (int i = 1; i < n; i ++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (needle.charAt(i) == needle.charAt(j)) j ++;
            next[i] = j;
        }
        return next;
    }
}


