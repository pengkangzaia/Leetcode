/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

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


}
