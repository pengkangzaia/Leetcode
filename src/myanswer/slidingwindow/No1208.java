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


    public int equalSubstring1(String s, String t, int maxCost) {
        // 滑动窗口
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        int currCost = 0;
        while (right < s.length()) {
            if (s.charAt(right) == t.charAt(right)) {
                right++;
            } else {
                int c = Math.abs(s.charAt(right) - t.charAt(right));
                if (currCost + c <= maxCost) {
                    right++;
                    currCost += c;
                } else {
                    while (currCost + c > maxCost) {
                        currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                        left++;
                    }
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        No1208 no1208 = new No1208();
        int ans = no1208.equalSubstring1("abcd", "bcdf", 3);
        System.out.println(ans);
    }


}
