package com.guang.top57复原IP地址;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12){
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s,s.length(),0,4,path,res);
        return res;
    }
    //需要一个变量记录还有多少段没被分割
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if(begin == len){
            if (residue==0){
                res.add(String.join(".",path));
            }
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len){
                break;
            }
            if (residue * 3 < len - i){
                continue;
            }
            if (judgeIpSegment(s,begin,i)){
                String currentIpSegment = s.substring(begin,i+1);
                path.addLast(currentIpSegment);
                dfs(s,len,i+1,residue-1,path,res);
                path.removeLast();
            }
        }

    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0'){
            return false;
        }
        int res = 0;
        while (left <= right){
            res = res * 10 + s.charAt(left) -'0';
            left++;
        }
        return  res>=0 && res <= 255;
    }
}
