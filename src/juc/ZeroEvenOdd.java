package juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @FileName: ZeroEvenOdd.java
 * @Description: No1116 打印零与奇偶数
 * @Author: camille
 * @Date: 2021/3/14 21:28
 */
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);



    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                semaphore2.release();
            } else {
                semaphore3.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            semaphore2.acquire();
            printNumber.accept(i);
            semaphore1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            semaphore3.acquire();
            printNumber.accept(i);
            semaphore1.release();
        }
    }


}
