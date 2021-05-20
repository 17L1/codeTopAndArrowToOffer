package com.guang.top51rand7ToRand10;

public class Solution {
    public int rand10(){
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10){
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }
    private int rand7(){
        int i = (int) Math.random();
        return i;
    }
}
