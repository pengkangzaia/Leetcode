package myanswer.dfsandbfs;

/**
 * @FileName: No130.java
 * @Description: No130.java类说明
 * @Author: admin
 * @Date: 2020/10/15 19:15
 */
public class No130 {

    /*private static char[][] grid = {
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'X'},
            {'O', 'X', 'X', 'X'}
    };*/

    public void solve(char[][] board) {
        // 边界条件判断
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    // 不能到达的O
                    board[i][j] = 'X';
                } else if (board[i][j] == '@') {
                    board[i][j] = 'O';
                }

            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '@';

        for (int q = 0; q < board.length; q++) {
            for (int p = 0; p < board[0].length; p++) {
                System.out.print(board[q][p]);
            }
            System.out.println();
        }
        System.out.println();


        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }


    public static void main(String[] args) {
        No130 no130 = new No130();
        int m = (int) (Math.random() * 10) + 1;
        int n = (int) (Math.random() * 10) + 1;
        char[] origin = {'X','O'};
        char[][] grid = new char[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int index = (int) (Math.random() + 0.5);
                grid[i][j] = origin[index];
            }
        }
        no130.solve(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }


}
