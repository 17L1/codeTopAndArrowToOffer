package com.guang.top34翻转字符串里的单词;

public class Solution {
    public String reverseWords(String s) {
        s= s.trim();
        int len = s.length();
        if (len < 1){
            return "";
        }
        StringBuilder res = new StringBuilder(len);
        int i = len - 1;
        int j = len - 1;
        while ( j >= 0 ){

            while (j >= 0 && s.charAt(j) != ' '){
                j--;
            }
            res.append(s.substring(j+1,i+1) + " ");
            while (j>= 0 && s.charAt(j) == ' '){
                j--;
            }
            i = j;
        }
        return res.toString().trim();
    }
}
