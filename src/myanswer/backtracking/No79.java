package myanswer.backtracking;

import java.util.LinkedList;

/**
 * @FileName: No79.java
 * @Description: 单词搜索
 * @Author: admin
 * @Date: 2020/10/27 9:56
 */
public class No79 {

    // 回溯三要素：
    // 路径
    // 结束条件
    // 可选选项

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                LinkedList<Character> path = new LinkedList<>();
                if (hasPath(board, word, path, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, String word, LinkedList<Character> path, int i, int j) {
        if (path.size() == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        int n = path.size();
        if (word.charAt(n) == board[i][j]) {
            path.add(board[i][j]);
            char temp = board[i][j];
            board[i][j] = '#';
            boolean flag = hasPath(board, word, path, i+1, j) ||
                    hasPath(board, word, path, i-1, j) ||
                    hasPath(board, word, path, i, j+1) ||
                    hasPath(board, word, path, i, j-1);
            board[i][j] = temp;
            path.removeLast();
            return flag;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        No79 no79 = new No79();
        boolean ans = no79.exist(board, "ABSF");
        System.out.println(ans);
    }
}
