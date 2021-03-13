package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @FileName: ConsumerAndProducer2.java
 * @Description: 阻塞队列实现生产者消费者
 * @Author: camille
 * @Date: 2021/3/13 23:51
 */
public class ConsumerAndProducer2 {

    private int queueSize = 10;
    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        queue.take();
                        System.out.println("取出元素，当前阻塞队列中元素个数为：" + queue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        queue.put(1);
                        System.out.println("添加元素，当前阻塞队列中元素个数为：" + queue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsumerAndProducer2 cp2 = new ConsumerAndProducer2();
        Consumer consumer = cp2.new Consumer();
        Producer producer = cp2.new Producer();
        producer.start();
        consumer.start();
    }



}
