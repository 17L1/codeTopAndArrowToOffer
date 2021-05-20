package com.guang.top82阻塞队列的实现;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 17L1
 * @date: 2021年05月19日 9:33 下午
 * @method：
 */
public class BlockingQueue<T> {
    private int size;
    private Object[] queue;
    private Lock lock =  new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int index;
    private int removeIndex;
    private int currLen;
    public BlockingQueue(){
        this(10);
    }
    public BlockingQueue(int size){
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        this.size = size;
        queue = new Object[size];
    }
    public void push(T element){
        lock.lock();
        try{
            while (currLen == size){
                System.out.println("队列满了");
                full.wait();
            }
            queue[index] = element;
            if (++index == size){
                index = 0;
            }
            currLen++;
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public T pop() throws InterruptedException {
        lock.lock();
        try{
            while (currLen == 0){
                System.out.println("队列空");
                empty.await();
            }
            Object obj = queue[removeIndex];
            if (++removeIndex == size){
                removeIndex = 0;
            }
            currLen--;
            full.signal();
            return (T)obj;
        }finally {
            lock.unlock();
        }
    }
}
