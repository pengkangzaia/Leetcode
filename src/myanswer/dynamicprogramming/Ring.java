package myanswer.dynamicprogramming;

/**
 * @author 彭康
 * @create 2021-08-21 11:02
 **/
public class Ring {

    public static void main(String[] args) {
//        int m = 2;
//        int n = 10;
//        int ans = cal(m, n);
//        System.out.println(ans);
//        System.out.println(find(m,n));

        int[][] dp = new int[2 + 1][10]; // 走i步到第j个节点的方案数
        dp[0][0] = 1;
//        dp[1][1] = 1;
//        dp[1][9] = 1;
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % 10] + dp[i - 1][(j - 1 + 10) % 10];
            }
        }
        System.out.println(dp[2][0]);

    }

    /**
     *
     * @param m 步数
     * @param n 节点个数
     * @return
     */
    private static int cal(int m, int n) {
        int[][] dp = new int[m + 1][n]; // 走i步到第j个节点的方案数
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[1][n - 1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % n] + dp[i - 1][(j - 1 + n) % n];
            }
        }
        return dp[m][0];


    }

    public static int find(int m, int n) {
        int length = m;//
        int[][] dp = new int[n + 1][length];//注意是n+1，走2步，走1步。走0步
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[1][length - 1] = 1;//
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= length - 1; j++) {
                //j-1+length是防止j-1=-1
                //%length防止j-1+length或者j+1超过数组大小，绕一圈
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
            }
        }
        return dp[n][0];
    }



}
