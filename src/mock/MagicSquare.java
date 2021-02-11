package mock;

/**
 * @FileName: MagicSquare.java
 * @Description: MagicSquare.java类说明
 * @Author: admin
 * @Date: 2021/2/11 11:09
 */
public class MagicSquare {

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;

        // 计算行前缀和数组，列前缀和数组
        int m = grid.length, n = grid[0].length;
        int[][] rowPrefix = new int[m][n];
        int[][] colPrefix = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    rowPrefix[i][j] = grid[i][j];
                } else {
                    rowPrefix[i][j] = rowPrefix[i][j - 1] + grid[i][j];
                }
                if (i == 0) {
                    colPrefix[i][j] = grid[i][j];
                } else {
                    colPrefix[i][j] = colPrefix[i - 1][j] + grid[i][j];
                }
            }
        }



        // 开始判断，先确定起始位置和结束位置
        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                // 先确定行之和是一样的，注意：这里是要前缀和之间相减的（求中间的值之和），而不是直接比较前缀和
                int rowSum1 = j == 2 ? rowPrefix[i][j] : rowPrefix[i][j] - rowPrefix[i][j - 3];
                int rowSum2 = j == 2 ? rowPrefix[i - 1][j] : rowPrefix[i - 1][j] - rowPrefix[i - 1][j - 3];
                int rowSum3 = j == 2 ? rowPrefix[i - 2][j] : rowPrefix[i - 2][j] - rowPrefix[i - 2][j - 3];
                if (rowSum1 == rowSum2 && rowSum2 == rowSum3) {
                    int colSum1 = i == 2 ? colPrefix[i][j] : colPrefix[i][j] - colPrefix[i - 3][j];
                    int colSum2 = i == 2 ? colPrefix[i][j - 1] : colPrefix[i][j - 1] - colPrefix[i - 3][j - 1];
                    int colSum3 = i == 2 ? colPrefix[i][j - 2] : colPrefix[i][j - 2] - colPrefix[i - 3][j - 2];
                    if (colSum1 == colSum2 && colSum2 == colSum3) { // 列之和
                        // 对角线之和
                        int diagonal1 = grid[i - 1][j - 1] + grid[i - 2][j - 2] + grid[i][j];
                        int diagonal2 = grid[i - 1][j - 1] + grid[i - 2][j] + grid[i][j - 2];
                        if (diagonal1 == diagonal2) {
                            // 检查满足条件的这些值是不是从1到9不同的数字
                            if (check(grid, i, j)) {
                                res++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int[][] grid, int i, int j) {
        // 频率数组
        int[] freq = new int[9];
        for (int row = i - 2; row <= i; row++) {
            for (int col = j - 2; col <= j; col++) {
                if (grid[row][col] > 9 || grid[row][col] < 1) {
                    return false;
                } else {
                    freq[grid[row][col] - 1]++;
                }
            }
        }
        for (int idx = 0; idx < freq.length; idx++) {
            if(freq[idx] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MagicSquare magicSquare = new MagicSquare();
        // [[3,2,9,2,7],[6,1,8,4,2],[7,5,3,2,7],[2,9,4,9,6],[4,3,8,2,5]]
        int[][] grid = {
                {3,2,9,2,7},
                {6,1,8,4,2},
                {7,5,3,2,7},
                {2,9,4,9,6},
                {4,3,8,2,5}
        };
        int ans = magicSquare.numMagicSquaresInside(grid);
        System.out.println(ans);
    }


}
