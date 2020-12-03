package myanswer.dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No994.java
 * @Description: 腐烂的橘子
 * @Author: admin
 * @Date: 2020/11/20 10:40
 */
public class No994 {

    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        // 找到所有为2的点加入队列
        // BFS查找周围为1的点，把他改成2，加入队列
        // 当队列为空，判断grid是否有1的点

        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                }
            }
        }
        // BFS遍历
        int minute = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                Integer rotted = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = rotted / n + dir[0];
                    int newCol = rotted % n + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(newRow * n + newCol);
                    }
                }
            }
            minute++;
        }
        // 当队列为空，判断grid是否有1的点。说明还有新鲜橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(minute - 1, 0);
    }

    public static void main(String[] args) {
        No994 no994 = new No994();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int ans = no994.orangesRotting(grid);
        System.out.println(ans);
    }

}
