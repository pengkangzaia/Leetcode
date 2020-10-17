package myanswer.dfsandbfs;

/**
 * @FileName: No200.java
 * @Description: 岛屿数量
 * @Author: admin
 * @Date: 2020/10/15 16:55
 */
public class No200 {

    /*
    思路：遍历岛这个二维数组，如果当前数为1，则进入感染函数并将岛个数+1
    感染函数：其实就是一个递归标注的过程，
    它会将所有相连的1都标注成2。为什么要标注？
    这样就避免了遍历过程中的重复计数的情况，
    一个岛所有的1都变成了2后，遍历的时候就不会重复遍历了。
    建议没想明白的同学画个图看看。
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void infect(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }

    public static void main(String[] args) {
        No200 no200 = new No200();
        char[][] grid = {
                {'1', '0'},
                {'0', '1'}
        };
        int numIslands = no200.numIslands(grid);
        System.out.println(numIslands);
    }

    ;

}
