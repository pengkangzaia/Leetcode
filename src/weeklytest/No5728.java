package weeklytest;

public class No5728 {

    public int minSideJumps(int[] obstacles) {
        int res = 0;
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        for (int i = n - 2; i >= 0; i--) {
            if (obstacles[i] == 0) {
                dp[i][0] = Math.min(Math.min(dp[i + 1][1], dp[i + 1][2]) + 1, dp[i + 1][0]);
                dp[i][1] = Math.min(Math.min(dp[i + 1][0], dp[i + 1][2]) + 1, dp[i + 1][1]);
                dp[i][2] = Math.min(Math.min(dp[i + 1][0], dp[i + 1][1]) + 1, dp[i + 1][2]);
            } else {
                if (obstacles[i] == 1) {
                    dp[i][0] = n * 1000;
                    dp[i][1] = Math.min(Math.min(dp[i + 1][0] + 2, dp[i + 1][2] + 1), dp[i + 1][1]);
                    dp[i][2] = Math.min(Math.min(dp[i + 1][0] + 2, dp[i + 1][1] + 1), dp[i + 1][2]);
                } else if (obstacles[i] == 2) {
                    dp[i][0] = Math.min(Math.min(dp[i + 1][1] + 2, dp[i + 1][2] + 1), dp[i + 1][0]);
                    dp[i][1] = n * 1000;
                    dp[i][2] = Math.min(Math.min(dp[i + 1][0] + 1, dp[i + 1][1] + 2), dp[i + 1][2]);
                } else {
                    dp[i][0] = Math.min(Math.min(dp[i + 1][1] + 1, dp[i + 1][2] + 2), dp[i + 1][0]);
                    dp[i][1] = Math.min(Math.min(dp[i + 1][0] + 1, dp[i + 1][2] + 2), dp[i + 1][1]);
                    dp[i][2] = n * 1000;
                }
            }
        }
        // dp[0][1] = Math.min(Math.min(dp[1][1], dp[1][2]), dp[1][0]);
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] ob = {0,2,1,0,3,0};
        No5728 no5728 = new No5728();
        int ans = no5728.minSideJumps(ob);
        System.out.println(ans);
    }


}
