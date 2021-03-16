package juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @FileName: FizzBuzz.java
 * @Description: No.1195 交替打印字符串
 * @Author: admin
 * @Date: 2021/3/16 13:45
 */
public class FizzBuzz {

    private int n;

    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore3 = new Semaphore(0);
    private Semaphore semaphore5 = new Semaphore(0);
    private Semaphore semaphore15 = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 15 != 0) {
                semaphore3.acquire();
                printFizz.run();
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 15 != 0) {
                semaphore5.acquire();
                printBuzz.run();
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // 要设置截至时间，不然线程会一直运行
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                semaphore15.acquire();
                printFizzBuzz.run();
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphore.acquire();
            if (i % 3 == 0 && i % 15 != 0) {
                semaphore3.release();
            } else if (i % 5 == 0 && i % 15 != 0) {
                semaphore5.release();
            } else if (i % 15 == 0) {
                semaphore15.release();
            } else {
                printNumber.accept(i);
                semaphore.release();
            }
        }
    }


}
