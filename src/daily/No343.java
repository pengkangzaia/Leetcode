package daily;

public class No343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j); // dp[i-j] 表示 数字 i-j 被切割之后的最优解
                dp[i] = Math.max(dp[i], (i - j) * j); // 还需要判断 数字 i-j 不被切割的情况
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No343 no343 = new No343();
        for (int i = 2; i <= 58; i++) {
            int ans = no343.integerBreak(i);
            System.out.println(i + " " + ans);
        }
    }


}
