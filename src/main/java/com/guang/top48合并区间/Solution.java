package com.guang.top48合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->a1[0] - a2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals){
            //如果结果数组是空的，或者当前区间的起始位置>结果数组中最后区间的终止位置
            //则不合并，直接将当前数组加入结果数组
            if (index == -1 || interval[0] > res[index][1]){
                res[++index] = interval;
            }else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }
}
