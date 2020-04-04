package MyAnswer.queue;

/**
 * 用数组实现队列
 */
public class ArrayQueue {
    private int maxSize;    //队列最大容量
    private int front;      //队列的首元素的前一个位置索引
    private int rear;       //队列的最后一个元素
    private int[] arr;      //构成队列的数组

    //构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[arrMaxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，请勿添加");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int removeQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不可弹出");
            throw new RuntimeException("队列为空，不可弹出");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有元素");
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int showFront() {
        if (isEmpty()) {
            System.out.println("队列为空，没有元素");
            throw new RuntimeException("队列为空，不可弹出");
        }
        return arr[front + 1];
    }


}
