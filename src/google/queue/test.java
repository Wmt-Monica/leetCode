package google.queue;

import org.junit.Test;

import java.util.Random;

/**
 * @Classname test
 * @Description TODO
 * @Date 2021/7/21 23:49
 * @Created by 翊
 */
public class test {

    @Test
    public void test() throws Exception {
        // 创建一个循环队列
        CircularQueue circularQueue = new CircularQueue(10);
        Random random = new Random();
        for (int i = 0; i < 9; i ++) {
            circularQueue.enqueue(random.nextInt(10));
        }

        System.out.println("队列的长度："+circularQueue.getLength());
        System.out.println("队列是否满："+circularQueue.isFull());

        // test
        for (int i = 0; i < 9; i ++) {
            circularQueue.dequeue();
        }

        System.out.println("队列的长度："+circularQueue.getLength());
        System.out.println("队列是否空："+circularQueue.isEmpty());
    }
}
