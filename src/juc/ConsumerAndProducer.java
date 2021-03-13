package juc;

import java.util.PriorityQueue;

/**
 * @FileName: ConsumerAndProducer.java
 * @Description: Object.wait()和Object.notify()、非阻塞队列实现生产者-消费者模式
 * @Author: camille
 * @Date: 2021/3/13 23:10
 */
public class ConsumerAndProducer {

    private final int queueSize = 10;
    private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);


    public static void main(String[] args) {
        ConsumerAndProducer cp = new ConsumerAndProducer();
        Producer producer = cp.new Producer();
        Consumer consumer = cp.new Consumer();

        producer.start();
        consumer.start();


    }


    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (queue) {
                    // 这里同步了
                    while (queue.size() == 0) {
                        try {
                            System.out.println("当前队列为空，请等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("从队列中移除一个元素，现在队列中剩余" + queue.size() + "个元素");
                }

            }
        }


    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列已满，等待有剩余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("从队列中添加一个元素，现在队列中存在" + queue.size() + "个元素");
//                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }
            }
        }

    }



}
