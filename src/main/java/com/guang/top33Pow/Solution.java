package com.guang.top33Pow;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1.0f;
        long b = n;
        if (b == 0){
            return 1;
        }
        if ( b < 0){
            x = 1 / x;
            b = -b;
        }
        if ((int)b == 1){
            return x;
        }
        while (b > 0){
            if (b % 2 == 0) {
                x *= x;
                b /= 2;
            }else {
                res *= x;
                b--;
            }
        }
        return res;
    }
}
