package MyAnswer.dynamicprogramming;

/**
 * @FileName: No70_2.java
 * @Description: 爬楼梯二刷
 * @Author: admin
 * @Date: 2020/9/30 13:32
 */
public class No70_2 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No70_2 no70_2 = new No70_2();
        int ans = no70_2.climbStairs(5);
        System.out.println(ans);
    }

}
