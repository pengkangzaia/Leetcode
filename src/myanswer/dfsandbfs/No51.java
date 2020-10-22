package myanswer.dfsandbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No51.java
 * @Description: N皇后
 * @Author: admin
 * @Date: 2020/10/19 19:39
 */
public class No51 {

    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        traverse(board, 0);
        return res;
    }

    private void traverse(char[][] board, int i) {
        if (i == board.length) {
            LinkedList<String> list = boardToList(board);
            res.add(list);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (valid(board, i, j)) {
                board[i][j] = 'Q';
                traverse(board, i + 1);
                board[i][j] = '.';
            }
        }
    }

    private LinkedList<String> boardToList(char[][] board) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            // 每一行都要新建一个StringBuilder
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean valid(char[][] board, int r, int c) {

        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        No51 no51 = new No51();
        List<List<String>> ans = no51.solveNQueens(9);
        for (List<String> strings : ans) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }


}
