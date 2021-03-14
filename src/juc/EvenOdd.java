package juc;

import java.util.concurrent.Semaphore;

/**
 * @FileName: EvenOdd.java
 * @Description: 多线程交替打印奇数偶数
 * @Author: camille
 * @Date: 2021/3/14 22:18
 */
public class EvenOdd {

    // 多线程交替打印奇数偶数
    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        Task task = evenOdd.new Task();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        task.printOdd();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        task.printEven();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }


    class Task {
        private Semaphore semaphore1 = new Semaphore(1);
        private Semaphore semaphore2 = new Semaphore(0);
        private volatile int num = 1;

        public Task() {
        }

        public void printOdd() throws InterruptedException {
            semaphore1.acquire();
            System.out.println(num++);
            semaphore2.release();
        }
        public void printEven() throws InterruptedException {
            semaphore2.acquire();
            System.out.println(num++);
            semaphore1.release();
        }
    }


}
