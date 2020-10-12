package myanswer.dynamicprogramming;

/**
 * @FileName: No72.java
 * @Description: 编辑距离
 * @Author: admin
 * @Date: 2020/10/12 14:06
 */
public class No72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            // 第一行
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            // 第一列
            dp[i][0] = i;
        }
        // 位置0表示空字符串，1表示字符串第一个字符，m表示字符串最后一个字符
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意：如果两字符相等，则直接不进行操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "hoswfewrse";
        String word2 = "wefcveros";
        No72 no72 = new No72();
        int ans = no72.minDistance(word1, word2);
        System.out.println(ans);
    }


}
