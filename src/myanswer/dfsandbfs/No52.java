package myanswer.dfsandbfs;

/**
 * @FileName: No52.java
 * @Description: N皇后2
 * @Author: admin
 * @Date: 2020/10/19 10:47
 */
public class No52 {

    private int res;

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        traverse(board, 0);
        return res;
    }

    private void traverse(boolean[][] board, int d) {
        if (d == board.length) {
            res++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (valid(board, d, i)) {
                board[d][i] = true;
                traverse(board, d + 1);
                board[d][i] = false;
            }
        }
    }

    private boolean valid(boolean[][] board, int r, int c) {
        // 同一行
        for (int i = 0; i < board.length; i++) {
            if(board[r][i]) {
                return false;
            }
        }
        // 同一列
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }
        // 左上
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // 右上
        for (int i = r, j = c; i>=0 && j< board.length; i--,j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No52 no52 = new No52();
        int ans = no52.totalNQueens(4);
        System.out.println(ans);
    }

}
