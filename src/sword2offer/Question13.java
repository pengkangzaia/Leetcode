package sword2offer;

public class Question13 {

    // 本题采用深度优先算法，递归遍历矩阵，把搜索过的节点设为true
    // 辅助函数，用于计算数位和
    public int numSum(int num) {
        return (num % 10) + (num / 10);
    }

    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        return dfs(0, 0, k, arr);
    }

    public int dfs(int i, int j, int k, int[][] arr) {
        // 如果下列条件满足，则不可达
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1
                || arr[i][j] == 1 || numSum(i) + numSum(j) > k) {
            return 0;
        }
        // 程序运行到此，说明该位置可达
        arr[i][j] = 1;
        return 1 + dfs(i - 1, j, k, arr) + dfs(i + 1, j, k, arr) +
                dfs(i, j - 1, k, arr) + dfs(i, j + 1, k, arr);

    }


    public static void main(String[] args) {
        int m = 16;
        int n = 8;
        int k = 4;
        Question13 question = new Question13();
        int ans = question.movingCount(m, n, k);
        System.out.println(ans);
    }

}
