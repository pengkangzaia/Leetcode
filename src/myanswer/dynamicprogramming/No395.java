package myanswer.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No395.java
 * @Description: 至少有K个重复字符的最长子串
 * @Author: admin
 * @Date: 2020/11/17 10:40
 */
public class No395 {

    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(sb.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }
        String[] strings = sb.toString().split(",");
        if (strings.length == 1) {
            return strings[0].length();
        }
        int res = 0;
        for (String string : strings) {
            res = Math.max(res, longestSubstring(string, k));
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "";
        int k = 3;
        No395 no395 = new No395();
        int ans = no395.longestSubstring(a, k);
        System.out.println(ans);
    }

}
