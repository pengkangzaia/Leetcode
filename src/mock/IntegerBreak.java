package mock;

/**
 * @FileName: IntegerBreak.java
 * @Description: IntegerBreak.java类说明
 * @Author: admin
 * @Date: 2021/3/9 15:58
 */
public class IntegerBreak {

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     */
    public int integerBreak(int n) {
        // dp[n] = dp[1]*dp[n-1]
        //
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i - 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(Math.max(Math.max(dp[i], dp[j] * dp[i - j]), dp[j] * (i - j)), j * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        for (int i = 2; i <= 58; i++) {
            System.out.println(i + " " + solution.integerBreak(i));
        }
    }

}
