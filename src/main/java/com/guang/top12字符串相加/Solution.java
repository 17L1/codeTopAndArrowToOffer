package com.guang.top12字符串相加;

public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0){
            return num2;
        }
        if (num2.length() == 0){
            return num1;
        }
        String s1 = reverse(num1);
        String s2 = reverse(num2);
        int len1 = s1.length();
        int len2 = s2.length();

        int len = Math.min(len1,len2);
        StringBuilder res = new StringBuilder(Math.max(len1,len2));
        int up = 0;
        int cur = 0;
        int i = 0;
        for (; i < len; i++) {
            cur = s1.charAt(i) + s2.charAt(i) - 2 * '0' + up;
            up = cur / 10;
            cur = cur % 10;
            res.append(String.valueOf(cur));
        }
        if (len1 < len2){
            s1 = s2;
        }
        for (; i < s1.length();i++){
            cur = s1.charAt(i) - '0' + up;
            up = cur / 10;
            cur = cur % 10;
            res.append(String.valueOf(cur));
        }
        if (up > 0){
            res.append(String.valueOf(cur));
        }
        return res.reverse().toString();

    }

    private String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
