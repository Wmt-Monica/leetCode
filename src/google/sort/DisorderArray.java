package google.sort;

import java.util.Random;

/**
 * @Classname DisorderArray
 * @Description TODO
 * @Date 2021/7/22 13:12
 * @Created by 翊
 * 生产无序数据类
 */
public class DisorderArray {

    int[] array;

    int maxSize;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public DisorderArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[this.maxSize];
    }

    // 创建无序数组
    public int[] createArray() {
        Random random = new Random();
        for (int i = 0; i < maxSize; i ++) {
            // 随机赋值 0 ~ 99 以内的数据
            array[i] = random.nextInt(100);
        }
        return array;
    }

    // 打印随机数组
    public void print() {
        for (int i = 0; i < maxSize; i ++) {
            System.out.print(array[i]+"\t");
            if (i != 0 && (i+1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < maxSize; i ++) {
            System.out.print(array[i]+"\t");
            if (i != 0 && (i+1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
