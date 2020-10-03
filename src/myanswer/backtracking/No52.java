/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

/**
 * @FileName: No52.java
 * @Description: N皇后2：求N皇后解决方案数量
 * @Author: admin
 * @Date: 2020/9/22 19:52
 */
public class No52 {

    public int cnt = 0;

    public int totalNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        traverse(visited, 0);
        return cnt;
    }

    /**
     * 回溯
     *
     * @param visited
     * @param row
     */
    public void traverse(boolean[][] visited, int row) {
        int n = visited.length;
        if (row == n) {
            cnt++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(visited, row, j)) {
                visited[row][j] = true;
                traverse(visited, row + 1);
                visited[row][j] = false;
            }
        }
    }

    public boolean isValid(boolean[][] visited, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < visited.length; i--, j++) {
            if (visited[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        No52 no52 = new No52();
        int ans = no52.totalNQueens(12);
        System.out.println("解法数量：" + ans);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start) + "ms");
    }


}
