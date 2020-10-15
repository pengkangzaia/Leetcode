package myanswer.dfsandbfs;

/**
 * @FileName: No130.java
 * @Description: No130.java类说明
 * @Author: admin
 * @Date: 2020/10/15 19:15
 */
public class No130 {

    private static char[][] grid = {
            {'X','O','X'},
            {'X','O','X'},
            {'O','X','X'}
    };

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !dfs(board, i, j)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private boolean dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return false;
        }
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
            return true;
        }
        return dfs(board, i + 1, j) || dfs(board, i - 1, j) ||
                dfs(board, i, j + 1) || dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        No130 no130 = new No130();
        no130.solve(grid);
        System.out.println(grid);
    }


}
