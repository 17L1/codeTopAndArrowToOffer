package com.guang.top69线程交替打印;

/**
 * @author: 17L1
 * @date: 2021年05月13日 5:54 下午
 * @method：synchronized
 */
public class Solution2 {
    private static boolean startA = true;
    private static boolean startB = false;
    private static boolean startC = false;
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() ->{
            synchronized (lock){
                for (int i = 0; i < 10;) {
                    if (startA){
                        System.out.print(Thread.currentThread().getName());
                        startA = false;
                        startB = true;
                        startC = false;
                        lock.notifyAll();
                        i++;
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        },"A").start();
        new Thread(() ->{
            synchronized (lock){
                for (int i = 0; i < 10;) {
                    if (startB){
                        System.out.print(Thread.currentThread().getName());
                        startA = false;
                        startB = false;
                        startC = true;
                        lock.notifyAll();
                        i++;
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        },"B").start();
        new Thread(() ->{
            synchronized (lock){
                for (int i = 0; i < 10;) {
                    if (startC){
                        System.out.print(Thread.currentThread().getName());
                        startA = true;
                        startB = false;
                        startC = false;
                        lock.notifyAll();
                        i++;
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        },"C").start();
    }
}
