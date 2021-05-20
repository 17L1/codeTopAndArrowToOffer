package com.guang.top71两段最大字段和;

import java.util.Scanner;

/**
 * @author: 17L1
 * @date: 2021年05月14日 1:48 下午
 * @method：
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if(m == 0){
            System.out.println(0);
        }
        int res = 0;

        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < a.length-1; i++) {
            sumLeft = getSum(a,0,i,m);
            sumRight = getSum(a,i+1,a.length-1,m);
            res = Math.max(res,sumLeft+sumRight);
        }
        System.out.println(res);
    }

    private static int getSum(int[] a, int left, int right, int m) {
        int ans = 0;
        int b = 0;
        int bNum = 0;
        for (int i = left; i <= right ; i++) {
            if (b+a[i] > a[i] || i == left){
                bNum++;
                if (bNum <= m){
                    b = b+a[i];
                }else{
                    bNum = 0;
                    b = a[i];
                }
            }else {
                bNum = 0;
                b = a[i];

            }
            if (b > ans){
                ans = b;
            }
        }
        return ans;
    }
}
