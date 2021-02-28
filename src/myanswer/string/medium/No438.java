package myanswer.string.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No438.java
 * @Description: No438.java类说明
 * @Author: camille
 * @Date: 2021/2/27 19:28
 */
public class No438 {

    public List<Integer> findAnagrams(String s, String p) {
        // 需要注意边界条件
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }

        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        int[] currFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            currFreq[s.charAt(i) - 'a']++;
            if(check(freq, currFreq)) {
                res.add(0);
            }
        }

        int left = 0, right = p.length() - 1;
        while (right < s.length() - 1) {
            right++;
            currFreq[s.charAt(right) - 'a']++;
            currFreq[s.charAt(left) - 'a']--;
            left++;
            if(check(freq, currFreq)) {
                res.add(left);
            }
        }

        return res;

    }

    private boolean check(int[] freq, int[] currFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != currFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        No438 no438 = new No438();
        List<Integer> ans = no438.findAnagrams(s, p);
        // "aaaaaaaaaa"
        //"aaaaaaaaaaaaa"
        System.out.println(ans);
    }


}
