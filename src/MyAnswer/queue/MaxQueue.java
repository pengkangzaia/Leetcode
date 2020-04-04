package MyAnswer.queue;

public class MaxQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    private int maxValue;

    public MaxQueue() {
        maxSize = 20000;
        front = -1;
        rear = -1;
        arr = new int[0];
        maxValue = -1;
    }

    public MaxQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[arrMaxSize];
        maxValue = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public int max_value() {
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = front + 1; i < arr.length; i++) {
                maxValue = Math.max(maxValue,arr[i]);
            }
            return maxValue;
        }
    }

    public void push_back(int value) {
        rear++;
        arr[rear] = value;
    }

    public int pop_front() {
        if(isEmpty()){
            return -1;
        }
        front++;
        return arr[front];
    }


}
