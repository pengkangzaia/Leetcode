package sword2offer;

public class Question14_1 {

    public int cuttingRope(int n) {
        // dp[n]表示对长度为n的绳子切割后，能得到的最大乘积。
        // 不包括长度为n的绳子不被切割的情况
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question14_1 question14_1 = new Question14_1();
        int ans = question14_1.cuttingRope(8);
        System.out.println(ans);
    }

}
