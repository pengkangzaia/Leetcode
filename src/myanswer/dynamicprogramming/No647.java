package myanswer.dynamicprogramming;

/**
 * @FileName: No647.java
 * @Description: 回文子串
 * @Author: admin
 * @Date: 2020/10/30 14:53
 */
public class No647 {

    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 转移方程，如果相等，看子串是否为回文串。没有子串，则直接为回文串
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

}
