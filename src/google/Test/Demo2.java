package google.Test;

import java.util.*;

/**
 * @Classname Demo2
 * @Description TODO
 * @Date 2022/4/16 16:47
 * @Created by 翊
 */
public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        int[] meterials = {3,2,4,1,2};
        int[][] cookbooks = {{1,1,0,1,2},{2,1,4,0,0},{3,2,4,1,0}};
        int[][] attribute = {{3,2},{2,4},{7,6}};
        int limit = 5;
        int max = demo2.perfectMenu(meterials, cookbooks, attribute, limit);
        System.out.println("max = "+max);
    }

    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        helper(materials, cookbooks, 0);
        int max = 0;
        for (List<Integer> i : list) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j : i) {
                sum2 += attribute[j][1];
                sum1 += attribute[j][0];
            }
            if (sum2 >= limit) {
                max = Math.max(max, sum1);
            }
        }
        if (max == 0) return -1;
        return max;
    }

    public void helper(int[] materials, int[][] cookbooks, int startIndex) {
        if (startIndex == cookbooks.length) {
            for (int i : path) {
                System.out.print(i);
            }
            System.out.println();
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < cookbooks.length; i ++) {
//            System.out.println(Arrays.toString(materials));
            if (judge(materials, cookbooks, i)) {
                System.out.println("1 = "+Arrays.toString(materials));
                for (int j = 0; j < 5; j ++) {
                    int num = cookbooks[i][j];
                    System.out.println(" = num = "+num);
                    materials[i] -= num;
                }
                System.out.println("2 = "+Arrays.toString(materials));
                path.add(i);
                helper(materials, cookbooks, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean judge(int[] materials, int[][] cookbooks, int startIndex) {
        int[] array1 = Arrays.copyOf(materials, materials.length);
        System.out.println("3 = "+Arrays.toString(array1));
        for (int i = 0; i < 5; i ++) {
            int num = cookbooks[startIndex][i];
            System.out.println("num = " +num);
            if (array1[i] < num) return false;
            array1[i] -= num;
        }
        System.out.println("4 = "+Arrays.toString(array1));
        return true;
    }
}
