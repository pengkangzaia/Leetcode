package daily;

/**
 * @FileName: No464.java
 * @Description: 岛屿的周长
 * @Author: admin
 * @Date: 2020/10/30 9:33
 */
public class No463 {

    public int islandPerimeter(int[][] grid) {
        // 一个小陆地，周围有x块陆地，贡献的周长就为4-x
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cnt = isLand(grid,i+1,j);
                    cnt += isLand(grid,i-1,j);
                    cnt += isLand(grid,i,j+1);
                    cnt += isLand(grid,i,j-1);
                    res += 4 - cnt;
                }
            }
        }
        return res;
    }

    private int isLand(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        No463 no463 = new No463();
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int[][] nums = {{1,1}};
        int ans = no463.islandPerimeter(nums);
        System.out.println(ans);
    }


}
