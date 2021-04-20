package com.guang.top20有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('?','?');
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if (s.charAt(i) == map.get(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
