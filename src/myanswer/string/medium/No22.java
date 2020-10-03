package myanswer.string.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No22 {
    // 解法有BUG
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }

        int len = 2 * n;
        char[] chars = new char[len];
        boolean[] used = new boolean[len];
        int left = 0; // 用于判断生成的括号序列是否合法
        int right = 0;
        for (int i = 0; i < len; i++) {
            /*if (i < n) {
                chars[i] = '(';
            } else {
                chars[i] = ')';
            }*/
            chars[i] = i < n ? '(' : ')';
        }
        dfs(chars, len, new StringBuilder(), 0, used, res, left, right);
        HashSet<String> hashSet = new HashSet<>(res);
        return new LinkedList<>(hashSet);

    }

    private void dfs(char[] chars, int len, StringBuilder sb,
                     int depth, boolean[] used, List<String> res, int left, int right) {
        if (depth == len) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                sb.append(chars[i]);
                used[i] = true;
                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                dfs(chars, len, sb, depth + 1, used, res, left, right);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        No22 no22 = new No22();
        List<String> ans = no22.generateParenthesis(3);
        for (String s : ans) {
            System.out.println(s);
        }
    }


}
