package myanswer.slidingwindow;

import java.util.HashSet;

/**
 * @FileName: No3.java
 * @Description: 无重复字符的最长子串
 * @Author: admin
 * @Date: 2021/1/7 11:37
 */
public class No3 {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int right = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, right - i);
        }
        return res;
    }

    public static void main(String[] args) {
        No3 no3 = new No3();
        int ans = no3.lengthOfLongestSubstring("abccabc");
        System.out.println(ans);
    }


}
