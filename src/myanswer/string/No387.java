package myanswer.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// 字符串中第一个唯一字符
public class No387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;

        int i = s.length() - 1;
        int[] count = new int[26];
        while (i >= 0) {
            count[s.charAt(i--) - 'a']++;
            //i--;
        }
        i = 0;
        while (i < s.length()) {
            // 第一个不重复的字符
            if (count[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No387 no387 = new No387();
        int ans = no387.firstUniqCharDaily("leetcode");
        System.out.println(ans);
    }

    // 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        // 不用map的解法,计数排序，两次遍历数组
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;

        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
            map.put(chars[i] - 'a', i); // key=当前字母-'a‘，value=下标
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                res = Math.min(res, map.get(i));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;*/
    }


    public int firstUniqCharDaily(String s) {
        int[] letters = new int[26];
        Arrays.fill(letters, -2);
        // -2表示没遍历过，-1表示遍历过多次
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (letters[index] == -1) {
            } else if (letters[index] == -2) {
                letters[index] = i;
            } else {
                letters[index] = -1;
            }
        }
        int res = n; // 索引最大为 n-1。
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != -1 && letters[i] != -2) {
                res = Math.min(letters[i], res);
            }
        }
        return res == n ? -1 : res;
    }


}
