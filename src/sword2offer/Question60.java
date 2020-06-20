package sword2offer;

public class Question60 {

    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int point = 1; point <= 6; point++) {
                    if (j - point > 0) {
                        dp[i][j] += dp[i - 1][j - point];
                    } else break;
                }
            }
        }
        double total = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[n][n + i] / total;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question60 question60 = new Question60();
        double[] ans = question60.twoSum(2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
