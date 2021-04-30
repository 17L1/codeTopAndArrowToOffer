package com.guang.top35字符串转换整数;

public class Solution {
    public int myAtoi(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        int index = 0;
        boolean light = false;
        while (index < len && array[index] == ' '){
            index++;
        }
        if (index == len){
            return 0;
        }
        if (array[index] == '-'){
            light = true;
            index++;
        }else if (array[index] == '+'){
            light = false;
            index++;
        }else if (!Character.isDigit(array[index])){
            return 0;
        }
        int res = 0;
        while (index < len && Character.isDigit(array[index])){
            int num = array[index] - '0';
            if (res > (Integer.MAX_VALUE - num)/10){
                return light?Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + num;
            index++;
        }
        return light ? -res : res;
    }
}
