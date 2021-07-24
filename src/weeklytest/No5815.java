package weeklytest;

/**
 * @author 彭康
 * @create 2021-07-18 11:05
 **/
public class No5815 {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] - Math.abs(j - k));
                }
                dp[i][j] += points[i][j];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 1;
        for (int i = 0; i < 31; i++) {
            System.out.println(num);
            num = num << 1;
        }
    }

}
