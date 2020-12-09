package myanswer.juc;

import java.util.concurrent.Semaphore;

/**
 * @FileName: SemaphoreTest.java
 * @Description: juc 类信号量 demo
 * @Author: admin
 * @Date: 2020/12/7 19:31
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("致死武器已授权，q/9");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("只有懦夫才会逃跑");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }

}
