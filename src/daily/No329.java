package daily;

public class No329 {
    // 直接用DFS回溯，超时
    /*public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // depth为没选当前点的depth
                res = Math.max(res, dfs(matrix, visited, 0, i, j, i + 1, j, m, n));
                res = Math.max(res, dfs(matrix, visited, 0, i, j, i - 1, j, m, n));
                res = Math.max(res, dfs(matrix, visited, 0, i, j, i, j + 1, m, n));
                res = Math.max(res, dfs(matrix, visited, 0, i, j, i, j - 1, m, n));
            }
        }
        // 1 -> 2 -> 3
        //返回的res为 depth = 0 -> 1 -> 2
        // 最后结果要加 1
        return res + 1;
    }*/

    /*private int dfs(int[][] matrix, boolean[][] visited, int depth, int preX, int preY, int i, int j, int m, int n) {
        // 越界检查
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[preX][preY] >= matrix[i][j]) {
            return depth;
        }
        visited[i][j] = true;
        int res = 0;
        res = Math.max(res, dfs(matrix, visited, depth + 1, i, j, i + 1, j, m, n));
        res = Math.max(res, dfs(matrix, visited, depth + 1, i, j, i - 1, j, m, n));
        res = Math.max(res, dfs(matrix, visited, depth + 1, i, j, i, j - 1, m, n));
        res = Math.max(res, dfs(matrix, visited, depth + 1, i, j, i, j + 1, m, n));
        visited[i][j] = false;
        return res;
    }*/

    public static void main(String[] args) {
        No329 no329 = new No329();
        int[][] matrix = {{9}
        };
        int ans = no329.longestIncreasingPath(matrix);
        System.out.println(ans);
    }


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //visited有两个作用：1.判断是否访问过，2.存储当前格子的最长递增长度
        int[][] visited = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 0) {
                    //这里先做一次比较找出max，可以避免最后再去遍历一个visited数组
                    max = Math.max(max, dfs(i, j, matrix, visited));
                }
                //max = Math.max(max, visited[i][j]);

            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (visited[i][j] > 0) {
            return visited[i][j];
        }
        int max = 0;
        //这里分别去判断四周是否比当前数小，然后去递归遍历
        // 如果当前格子比四周的都小，则返回max=0，加上当前的1个格子
        if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i - 1, j, matrix, visited));
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i + 1, j, matrix, visited));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j - 1, matrix, visited));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j + 1, matrix, visited));
        }

        visited[i][j] = max + 1;
        return max + 1;


    }


}
