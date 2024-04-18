package google.queue;

/**
 * @Classname CircularQueue
 * @Description TODO
 * @Date 2021/7/21 23:34
 * @Created by 翊
 * 循环队列，其中 tail 指针的位置要浪费不能存放数据
 */
public class CircularQueue {

    // 队列头
    private int head;

    // 队列尾
    private int tail;

    // 队列最大长度
    private int maxSize;

    // 数组模拟队列
    private int[] queue;

    // 初始化数组
    public CircularQueue(int maxSize) {
        this.head = 0;
        this.tail = 0;
        this.maxSize = maxSize;
        this.queue = new int[this.maxSize];
    }

    // 入队
    public void enqueue(int data) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满，入队失败");
        } else {
            // 将队列尾部指针下移
            tail = (tail+1) % maxSize;
            queue[tail] = data;
            System.out.println("入队成功");
        }
    }

    // 出队
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已空，出队失败");
        } else {
            int data = queue[head];
            // 将队列头部指针下移
            head = (head+1) % maxSize;
            System.out.println("出队成功");
            return data;
        }
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == tail;
    }

    // 判断队列是否满
    public boolean isFull() {
        return (tail+1) % maxSize == head;
    }

    // 获取队列长度
    public int getLength() {
        return (tail - head + maxSize) % maxSize;
    }
}
