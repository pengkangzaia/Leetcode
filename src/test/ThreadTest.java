package test;

import java.util.concurrent.Semaphore;

/**
 * @FileName: ThreadTest.java
 * @Description: ThreadTest.java类说明
 * @Author: admin
 * @Date: 2021/3/25 10:26
 */
public class ThreadTest {

    private static final Semaphore s1 = new Semaphore(1);
    private static final Semaphore s2 = new Semaphore(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    s1.acquire();
                    System.out.println("我是线程1");
                    s2.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    s2.acquire();
                    System.out.println("我是线程2");
                    s1.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        t2.start();

    }





}
