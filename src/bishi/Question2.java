package bishi;

import java.util.Scanner;

public class Question2 {

    /**
     * 给定X*Y的网格，
     * 小苏要在此网格上从左上角到右下角，
     * 只能走格点且只能向右或向下走，
     * 求可行的走法数目
     *
     * @param x 网格的行数
     * @param y 网格的列数
     * @return 可行的走法
     */
    public int gridWays(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        dp[0][0] = 0; // 从起始位置到（0，0）的可能走法
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("网格大小为：" + x + "*" + y);
        int ans = question2.gridWays(x, y);
        System.out.println("可行的走法有" + ans + "种");
    }

}
