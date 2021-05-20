package com.guang.top70生产者消费者;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 17L1
 * @date: 2021年05月13日 10:06 下午
 * @method：
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Consumer4 consumer = new Consumer4();
    }
}
class Consumer4{
    private volatile Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment(){
        lock.lock();


        try {
            while (num!=1) {
                condition.await();
            }
            num++;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while(num==0){
                condition.await();
            }
            num--;
            condition.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
