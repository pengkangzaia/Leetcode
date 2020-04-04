package MyAnswer.dynamicprogramming;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int ans = coinChange(coins,amount);
        System.out.println(ans);
    }

    private static int coinChange(int[] coins, int amount) {
        //注意特殊情况，总金额为0时，随便那种硬币都可以凑出结果
        if(amount==0&&coins.length>0&&coins!=null){
            return 0;
        }
        //动态规划
        //其实可以用Arrays.fill方法

        int[] dp = new int[amount+1];
        //Arrays.fill(dp,amount+1);
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]>amount){
                continue;
            }
            dp[coins[i]]=1;
        }
        int j = 1;
        while (j<=amount){
            if(dp[j]==0){
                for (int i = 0; i < coins.length; i++) {
                    if(j>coins[i]&&dp[j-coins[i]]!=0){
                        if(dp[j]==0){
                            dp[j]=dp[j-coins[i]]+1;
                        }
                        else {
                            dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                        }
                    }
                }
            }
            j++;
        }
        if(dp[amount]==0){
            return -1;
        }else {
            return dp[amount];
        }
    }
}
