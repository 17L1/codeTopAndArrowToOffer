package com.guang.top25用栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> stackHelp;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList<>();
        stackHelp = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stackHelp.isEmpty()){
            return stackHelp.removeLast();
        }
        while (!stack.isEmpty()){
            stackHelp.addLast(stack.removeLast());
        }
        return stackHelp.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        if (!stackHelp.isEmpty()){
            return stackHelp.getLast();
        }
        while (!stack.isEmpty()){
            stackHelp.addLast(stack.removeLast());
        }
        return stackHelp.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stackHelp.isEmpty();
    }
}
