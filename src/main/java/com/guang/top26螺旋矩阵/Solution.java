package com.guang.top26螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final int INF = 101;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[][] light = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int i = 0,x = 0,y = 0, d =0; i < m*n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = INF;
            int tmpx = x + light[d][0];
            int tmpy = y + light[d][1];
            if (tmpx < 0 || tmpx >= m || tmpy <0 || tmpy >= n || matrix[tmpx][tmpy] == INF){
                d = (d+1)%4;
                tmpx = x + light[d][0];
                tmpy = y + light[d][1];
            }
            x = tmpx;
            y = tmpy;

        }
        return res;
    }
}
