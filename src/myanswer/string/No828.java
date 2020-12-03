package myanswer.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No828.java
 * @Description: 独特字符串
 * @Author: admin
 * @Date: 2020/11/23 9:34
 */
public class No828 {

    private int res = 0;
    private HashMap<String, Integer> substringCount = new HashMap<>();

    public int uniqueLetterString(String s) {
        //  全排列+哈希表记录当前字符串个数+回溯
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dfs(s, map, i, i); // 开始位置，当前位置
        }
        return res;
    }

    // map存curr之前的字符信息
    public void dfs(String s, Map<Character, Integer> map, int start, int curr) {
        if (curr >= s.length()) {
            map.clear();
            return;
        }
        String key = s.substring(start, curr + 1);
        if (substringCount.containsKey(key)) {
            res += substringCount.get(key);
        } else {
            // 还是要计算字串的唯一字符的个数
            int num = count(s, map, curr);
            substringCount.put(key, num);
            res += num;
        }
        if (start == curr) {
            map.put(s.charAt(curr), 1);
        }
        dfs(s, map, start, curr + 1);
    }

    public int count(String s, Map<Character, Integer> map, int curr) {
        int onlyCount = 0;
        char c = s.charAt(curr);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
        // map.put(c, map.getOrDefault(c, 0) + 1);
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                onlyCount++;
            }
        }
        return onlyCount;
    }

    public static void main(String[] args) {
        No828 no828 = new No828();
        int ans = no828.uniqueLetterStringFromLeetCode("leetcode");
        System.out.println(ans);
    }

    // 参考网上答案
    // https://leetcode-cn.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/c-you-li-zi-yi-dong-by-smilyt_/
    public int uniqueLetterStringFromLeetCode(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int r = i - 1, l = i + 1;
            while (r >= 0 && s.charAt(r) != s.charAt(i)) {
                r--;
            }
            left[i] = r;
            while (l < n && s.charAt(l) != s.charAt(i)) {
                l++;
            }
            right[i] = l;
            res += (i - left[i]) * (right[i] - i);
        }
        return res;
    }


}
