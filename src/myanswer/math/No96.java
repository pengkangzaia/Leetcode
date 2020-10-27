package myanswer.math;

/**
 * @FileName: No96.java
 * @Description: 不同的搜索二叉树
 * @Author: admin
 * @Date: 2020/10/27 13:25
 */
public class No96 {

    // f(n)=f(0)*f(n-1)+f(1)*f(n-2)+...+f(n-1)*f(0);

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No96 no96 = new No96();
        for (int i = 1; i < 100; i++) {
            int numTrees = no96.numTrees(i);
            System.out.println(numTrees);
        }
    }


}
