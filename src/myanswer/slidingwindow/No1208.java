package myanswer.slidingwindow;

/**
 * @FileName: No1208.java
 * @Description: 尽可能使字符串相等
 * @Author: admin
 * @Date: 2021/2/5 19:47
 */
public class No1208 {


    public int equalSubstring(String s, String t, int maxCost) {
        // 前提：字符串长度相同
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0, res = 0;
        while (right < n) {
            maxCost -= cost[right];
            right++;
            while (maxCost < 0) {
                maxCost += cost[left];
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }


}
