package com.guang.top43最小栈;

import java.util.Stack;

public class MinStack3 {
    private Stack<Integer> stack;
    long min;
    public MinStack3() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            min = x;
            stack.push((int) (x - min));
        }else {
            stack.push((int) (x-min));
            if (x < min){
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        long pop = stack.pop();
        if (pop < 0){
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < 0){
            return (int)min;
        }else {
            return (int) (min + top);

        }
    }

    public int getMin() {
        return (int) min;

    }
}

