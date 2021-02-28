package myanswer.dfsandbfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No542_BFS.java
 * @Description: 01矩阵
 * @Author: camille
 * @Date: 2021/2/27 21:29
 */
public class No542_BFS {

    public int[][] updateMatrix(int[][] matrix) {
        Deque<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = point[0] + dx[i];
                int col = point[1] + dy[i];
                // -1表示没有被遍历到的1
                // 先看0能到-1的，再看1能到达-1的，
                if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] == -1) {
                    matrix[row][col] = matrix[point[0]][point[1]] + 1;
                    queue.offer(new int[] {row, col});
                }
            }
        }
        return matrix;

    }


}
