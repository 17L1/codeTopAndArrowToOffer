package com.guang.top23岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!inArea(grid,i,j)){
            return;
        }
        if (grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 2;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return i < grid.length && i >= 0 && j < grid[0].length && j >= 0;
    }
}
