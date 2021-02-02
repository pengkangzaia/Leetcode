/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No51.java
 * @Description: N皇后问题, N个皇后放在N*N的棋盘上
 * @Author: admin
 * @Date: 2020/9/22 14:48
 */
public class No51 {
    // 优化记录：不用cnt记录，如果不符合直接返回false
    // 一行确定了，这行剩下的点就不用查找了
    // 我这里对每个点都判断了一遍，这样不好

    public List<List<String>> res = new LinkedList<>();

    /**
     * List<String> 表示一个解
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // 回溯算法三要素
        // 1. 路径（已选择集合）
        // 2. 待选择集合
        // 3. 结束条件
        boolean[][] visit = new boolean[n][n];
        traverse(visit, 0);
        return res;
    }

    public void traverse(boolean[][] visit, int idx) {
        if (idx == visit.length) {
            LinkedList<String> list = visitToList(visit);
            res.add(list);
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                if (visit[i][j] || !isValid(visit, i, j)) {
                    continue;
                }
                visit[i][j] = true;
                traverse(visit, idx + 1);
                visit[i][j] = false;
            }
        }
    }

    public LinkedList<String> visitToList(boolean[][] visit) {
        LinkedList<String> ans = new LinkedList<>();
        for (int i = 0; i < visit.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < visit[0].length; j++) {
                char c = visit[i][j] ? 'Q' : '.';
                sb.append(c);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public boolean isValid(boolean[][] visit, int a, int b) {

        int n = visit.length;
        for (int i = 0; i < n; i++) {
            if (visit[i][b]) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (visit[a][j]) {
                return false;
            }
        }
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                if (Math.abs(i - a) == Math.abs(j - b) && visit[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        No51 no51 = new No51();
        List<List<String>> res = no51.solveNQueens(4);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println("==============");
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start) + "ms");
        System.out.println(res.size());

    }


    public List<List<String>> solveNQueens1(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new LinkedList<>();
        search(board, res, 0); // 从第0行开始
        return res;
    }

    private void search(char[][] board, List<List<String>> res, int row) {
        if (row == board.length) {
            res.add(boardToList(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // 判断当前位置是否可以放置皇后
            if (isPlaceable(board, row, col)) {
                board[row][col] = 'Q';
                search(board, res, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> boardToList(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            res.add(String.valueOf(chars));
        }
        return res;
    }

    private boolean isPlaceable(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 同一行不需要判断
        // 判断对角线
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
