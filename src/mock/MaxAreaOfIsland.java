package mock;

/**
 * @FileName: MaxAreaOfIsland.java
 * @Description: MaxAreaOfIsland.java类说明
 * @Author: camille
 * @Date: 2021/1/4 21:30
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int currNum = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flood(grid, i, j, currNum);
                    currNum++;
                }
            }
        }
        int[] count = new int[currNum + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count[grid[i][j]]++;
            }
        }
        int res = 0;
        for (int i = 2; i < count.length; i++) {
            res = Math.max(res, count[i]);
        }
        return res;
    }

    private void flood(int[][] grid, int row, int col, int currNum) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if (grid[row][col] == 1) {
            grid[row][col] = currNum;
            flood(grid, row - 1, col, currNum);
            flood(grid, row + 1, col, currNum);
            flood(grid, row, col - 1, currNum);
            flood(grid, row, col + 1, currNum);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int ans = maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1}});
        System.out.println(ans);
    }



}
