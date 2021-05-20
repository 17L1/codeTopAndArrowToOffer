package com.guang.top69线程交替打印;

import java.util.concurrent.Semaphore;

/**
 * @author: 17L1
 * @date: 2021年05月13日 6:11 下午
 * @method：Semaphore
 */
public class Solution4 {

    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getName());
                semaphoreB.release();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getName());
                semaphoreC.release();
            }
        },"B").start();new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getName());
                semaphoreA.release();
            }
        },"C").start();
    }
}
