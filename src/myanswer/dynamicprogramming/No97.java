package myanswer.dynamicprogramming;

/**
 * @FileName: No97.java
 * @Description: 交错字符串
 * @Author: admin
 * @Date: 2020/10/12 16:47
 */
public class No97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n != t) {
            return false;
        }
        // 定义dp[i][j]为字符串1的前i个元素和字符串的前j个元素是否能交错组成字符串3的前i+j个元素
        boolean[][] dp = new boolean[m+1][n+1];
        // 初始化dp数组
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j - 1;
                // 注意字符的索引获取方法
                if (i > 0) {
                    dp[i][j] = dp[i][j] || ((s1.charAt(i - 1) == s3.charAt(k)) && dp[i-1][j]);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || ((s2.charAt(j - 1) == s3.charAt(k)) && dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        No97 no97 = new No97();
        boolean interleave = no97.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }



}
