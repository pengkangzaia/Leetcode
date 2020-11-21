package myanswer.array.medium;

import java.util.HashMap;

/**
 * @FileName: No36.java
 * @Description: 有效的数独
 * @Author: camille
 * @Date: 2020/11/21 16:17
 */
public class No36 {

    public boolean isValidSudoku(char[][] board) {
        // 9 * 9
        // 每一个block的索引
        // int blockIndex = row / 3 * 3 + col / 3;
        int m = board.length;
        int n = board[0].length;
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int boxIndex = i / 3 * 3 + j / 3;
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num]++;
                    cols[j][num]++;
                    boxes[boxIndex][num]++;
                    if (rows[i][num] > 1 || cols[j][num] > 1 || boxes[boxIndex][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
