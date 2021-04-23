package com.guang.top24最长回文子串;

import java.util.Arrays;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1){
            return "";
        }
        int maxLen = 1;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for(int j = 0;  j < len; j++){
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i + 1 <= 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (j - i + 1 > maxLen && dp[i][j]){
                    maxLen = j - i + 1;
                    left = i;
                    right = j;
                }

            }
        }
        return s.substring(left,right + 1);

    }
}
