package com.guang.top24最长回文子串;

/**
 * @author: 17L1
 * @date: 2021年05月13日 4:34 下午
 * @method：
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1){
            return "";
        }
        //判断子串s(i,j+1)是否为回文串
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int left = 0;
        int right = 0;
        //长度为1的子串都为回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i ; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(j-i+1 < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if ( j - i + 1 > maxLen && dp[i][j] == true){
                    maxLen = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
