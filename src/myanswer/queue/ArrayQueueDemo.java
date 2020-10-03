package myanswer.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        System.out.println(queue.showFront());
        queue.addQueue(3);
        queue.addQueue(5);
        queue.showQueue();
        //queue.addQueue(7);
        System.out.println(queue.removeQueue());
        queue.showQueue();

    }
}
