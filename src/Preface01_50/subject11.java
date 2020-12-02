package Preface01_50;

/**
 * 力扣题库 13 ：
 * 罗马数字转整数
 */
public class subject11 {
    public static void main(String[] args) {
        int result = new Solution().romanToInt("DCXXI");
        System.out.println(result);
    }
    static class Solution {
        public int romanToInt(String s) {
            char[] chars = s.toCharArray();  // 将罗马数字的字符串转成字符数组
            int result = 0;
            for (int i = 0; i < chars.length; i ++){
                switch (chars[i]){
                    case 'I' : {
                        if (i+1 < chars.length){
                            if (chars[i+1] == 'V'){
                                result += 4;
                                i ++;
                                break;
                            }else if (chars[i+1] == 'X'){
                                result += 9;
                                i ++;
                                break;
                            }
                        }
                        result += 1;
                        break;
                    }
                    case 'X' : {
                        if (i+1 < chars.length){
                            if (chars[i+1] == 'L'){
                                result += 40;
                                i ++;
                                break;
                            }else if (chars[i+1] == 'C'){
                                result += 90;
                                i ++;
                                break;
                            }
                        }
                        result += 10;
                        break;
                    }
                    case 'C' : {
                        if (i+1 < chars.length){
                            if (chars[i+1] == 'D'){
                                result += 400;
                                i ++;
                                break;
                            }else if (chars[i+1] == 'M'){
                                result += 900;
                                i ++;
                                break;
                            }
                        }
                        result += 100;
                        break;
                    }
                    case 'V' : result += 5; break;
                    case 'L' : result += 50; break;
                    case 'D' : result += 500; break;
                    case 'M' : result += 1000; break;
                }
            }
            return result;
        }
    }
}
