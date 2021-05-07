package com.guang.top43最小栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helpStack;
    public MinStack() {
        stack = new Stack<>();
        helpStack = new Stack<>();
        helpStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        if (x < helpStack.peek()){
            helpStack.push(x);
        }else {
            helpStack.push(helpStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        helpStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }
}
