package myanswer.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No279.java
 * @Description: No279.java类说明
 * @Author: camille
 * @Date: 2020/10/9 22:59
 */
public class No279 {

    public int numSquares(int n) {
        // 动态规划，三要素
        // 重叠子问题
        // 最优子结构
        // 转移方程: dp[i] = Min(dp[i-j] + 1)   for j in (1,4,9,16...)
        int[] dp = new int[n+1];
        // 初始化dp数组
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        // 优化1：HashSet存放完全平方数：反而更慢了...因为没有减少循环次数
        // 优化2：List存放完全平方数：可以按照索引查询
        // 优化3：dp数组初始化可以放在后面的循环
        List<Integer> list = new LinkedList();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            list.add(i*i);
        }
        int a = 0;
        for (int i = 2; i <= n; i++) {
            a = (int) Math.sqrt(i);
            if (a * a == i) {
                // i是完全平方数，直接等于1
                dp[i] = 1;
                continue;
            }

            for (int j = 0; j < list.size(); j++) {
                if(list.get(j) < i) {
                    dp[i] = Math.min(dp[i], dp[i-list.get(j)] + 1);
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }

    // leetcode大神解法，更快。快在不用list存完全平方数，以及初始化数组放在了后面的循环里
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No279 no279 = new No279();
        int i = no279.numSquares1(12);
        System.out.println(i);
    }





}
