package myanswer.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No212.java
 * @Description: 单词搜索2
 * @Author: admin
 * @Date: 2020/11/12 17:04
 */
public class No212 {

    private HashSet<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        // 不能搜索已经查找过的单词
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    dfs(board, words[i], j, k, new StringBuilder(), 0);
                }
            }
        }
        List<String> ans = new LinkedList<>(res);
        return ans;
    }

    private void dfs(char[][] board, String word, int i, int j, StringBuilder path, int idx) {
        if (path.length() == word.length()) {
            res.add(path.toString());
            return;
        }
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] == word.charAt(idx)) {
            path.append(board[i][j]);
            // 用set存结果，不然这里会累加4次重复的结果
            // 这里将当前字符屏蔽来防止后面回溯遍历到之前遍历过的字符
            // visit数组不是很好用，还要做数据越界判断
            char temp = board[i][j];
            board[i][j] = '#';
            dfs(board, word, i + 1, j, path, idx + 1);
            dfs(board, word, i - 1, j, path, idx + 1);
            dfs(board, word, i, j + 1, path, idx + 1);
            dfs(board, word, i, j - 1, path, idx + 1);
            board[i][j] = temp;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        No212 no212 = new No212();
        List<String> res = no212.findWords(board, words);
        System.out.println(res);
    }


}
