package myanswer.array.medium;

/**
 * @FileName: No289.java
 * @Description: 生命游戏
 * @Author: admin
 * @Date: 2020/11/20 17:26
 */
public class No289 {

    private int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(board, i, j, newBoard);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private void check(int[][] board, int row, int col, int[][] newBoard) {
        int count = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < board.length
                    && newCol >= 0 && newCol < board[0].length
                    && board[newRow][newCol] == 1) {
                count++;
            }
        }
        if (board[row][col] == 0 && count == 3) {
            newBoard[row][col] = 1; // 复活
        } else if (board[row][col] == 1) {
            if (count < 2 || count > 3) {
                newBoard[row][col] = 0; // 死亡
            } else {
                newBoard[row][col] = 1; // 保持原样
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        No289 no289 = new No289();
        no289.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
