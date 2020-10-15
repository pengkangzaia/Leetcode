package myanswer.dynamicprogramming;

/**
 * @FileName: No91.java
 * @Description: 解码方法
 * @Author: admin
 * @Date: 2020/10/13 14:32
 */
public class No91 {

    /**
     * 输入："226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * @param s
     * @return
     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        // 假设空字符串有一种解码方式（实际上是没有的）
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<=n; i++) {
            int range = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            // 这里不能是>=1，应该是>=10，03这种情况不能算两种
            if (range >= 10 && range <= 26) {
                if (range == 10 || range == 20) {
                    dp[i] = dp[i-2];
                } else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            } else {
                if (s.charAt(i-1) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[n];
    }

    public int numDecodings1(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1) != '0') {
                nums[i] = nums[i-1];
            }
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2] ;
            }


        }
        return nums[s.length()] ;
    }

    public static void main(String[] args) {
        No91 no91 = new No91();
        int ans = no91.numDecodings("01");
        System.out.println(ans);
    }


}
