package com.guang.top58滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 1){
            return null;
        }
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //判断对首元素是否移除滑动窗口
            if (i >= k && !queue.isEmpty()&&queue.peekFirst()==i-k){
                queue.removeFirst();
            }
            //依次判断待添加元素是否比对首元素大，注意可以取等号
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if (i-k+1 >= 0){
                res[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
