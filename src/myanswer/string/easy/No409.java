package myanswer.string.easy;

/**
 * @FileName: No409.java
 * @Description: 最长回文串
 * @Author: admin
 * @Date: 2021/2/22 18:51
 */
public class No409 {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] small = new int[26];
        int[] big = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                small[c - 'a']++;
            }
            if (c >= 'A' && c <= 'Z') {
                big[c - 'A']++;
            }
        }
        int res = 0;
        boolean remain = false;
        for (int i = 0; i < small.length; i++) {
            if (small[i] > 0) {
                if (small[i] % 2 == 0) {
                    res += small[i];
                } else {
                    if (!remain) {
                        res += small[i];
                        remain = true;
                    } else {
                        res += small[i] - 1;
                    }
                }
            }
            if (big[i] > 0) {
                if (big[i] % 2 == 0) {
                    res += big[i];
                } else {
                    if (!remain) {
                        res += big[i];
                        remain = true;
                    } else {
                        res += big[i] - 1;
                    }
                }
            }
        }

        return res;
    }


}
