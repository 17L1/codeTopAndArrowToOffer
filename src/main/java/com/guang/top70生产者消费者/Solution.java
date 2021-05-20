package com.guang.top70生产者消费者;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: 17L1
 * @date: 2021年05月19日 9:53 下午
 * @method：
 */
public class Solution {
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    blockingQueue.put(1);
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + blockingQueue.size());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + blockingQueue.size());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution test1 = new Solution();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }
}
