package com.guang.top69线程交替打印;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: 17L1
 * @date: 2021年05月13日 5:49 下午
 * @method：LockSupport
 */
public class Solution1 {
    static Thread threadA, threadB,threadC;
    public static void main(String[] args) {
        threadA = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        },"A");
        threadB = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadC);
                LockSupport.park();
            }
        },"B");
        threadC = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadA);
                LockSupport.park();
            }
        },"C");
        threadA.start();
        threadB.start();
        threadC.start();



    }
}
