package google.stack;

/**
 * @Classname ArrayStack
 * @Description TODO
 * @Date 2021/7/15 21:22
 * @Created by 翊
 * 使用数组模拟栈
 */
public class ArrayStack<T> {
    // 创建一个数组，初始大小为 20
    private T[] stack;

    private int MAXSIZE = 20;

    // 栈顶指针,初始处于 -1 的位置
    private int point = -1;

    public T[] getStack() {
        return stack;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // 初始化 stack 栈对象
    public ArrayStack() {
        this.stack = (T[]) new Object[MAXSIZE];
    }

    // 入栈操作
    public boolean add(T addData) {
        if (point < MAXSIZE) {
            point ++;
            stack[point] = addData;
        } else {
            System.out.println("栈满，无法添加入栈");
            return false;
        }
        return true;
    }

    // 出栈操作
    public boolean pop() {
        if (point < 0) {
            System.out.println("栈空，无法出栈操作");
            return false;
        } else {
            point --;
        }
        return true;
    }

    // 显示栈顶元素
    public T pep() {
        if (!isEmpty()) {
            return stack[point];
        } else {
            System.out.println("栈为空");
            return null;
        }
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return point < 0;
    }

    // 打印栈
    public void print() {
        int i = point;
        while (i >= 0) {
            System.out.print(stack[i]+"\t");
            i --;
        }
        System.out.println();
    }


}
