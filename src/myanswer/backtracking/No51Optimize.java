/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No51Optimize.java
 * @Description: N皇后参考别人的思路之后的优化代码
 * @Author: admin
 * @Date: 2020/9/22 19:05
 */
public class No51Optimize {

    public List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
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
        for (int j = 0; j < visit.length; j++) {
            if (!isValid(visit, idx, j)) {
                continue;
            }
            visit[idx][j] = true;
            traverse(visit, idx + 1);
            visit[idx][j] = false;
        }
    }

    public boolean isValid(boolean[][] visit, int a, int b) {
        // 每一次选择一层，每次只需判断当前位置和上面的是否符合
        int n = visit.length;
        for (int i = 0; i <= a; i++) {
            if (visit[i][b]) {
                return false;
            }
        }
        // 只判断左上和右上对角线元素
        for (int i = a - 1, j = b - 1; i >= 0 && j >= 0; i--, j--) {
            if (visit[i][j]) {
                return false;
            }
        }
        for (int i = a - 1, j = b + 1; i >= 0 && j < n; i--, j++) {
            if (visit[i][j]) {
                return false;
            }
        }
        return true;
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        No51Optimize no51Optimize = new No51Optimize();
        List<List<String>> res = no51Optimize.solveNQueens(9);
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


}
