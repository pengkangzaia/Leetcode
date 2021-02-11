package myanswer.string.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: No567.java
 * @Description: No567.java类说明
 * @Author: admin
 * @Date: 2021/2/10 23:22
 */
public class No567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // 计算字母频率，滑动窗口遍历。每次遍历同时更新频率数组和当前长度。如果当前长度等于s1长度就判断频率数组是否为空
        int[] freq = new int[26];
        int[] window = new int[26];
        // 初始化freq数组
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int len1 = s1.length(), len2 = s2.length();
        int left = 0, right = 0, currLen = 0; // 左闭右开区间
        while (right < len2) {
            char c = s2.charAt(right);
            window[c - 'a']++;
            right++;
            currLen = right - left;
            if (currLen == len1) {
                if (checkArray(freq, window)) {
                    return true;
                } else {
                    // 左指针右移
                    window[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
        }
        return false;
    }

    private boolean checkArray(int[] freq, int[] window) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != window[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No567 no567 = new No567();
        boolean ans = no567.checkInclusion("ab", "eidboaoo");
        System.out.println(ans);
    }


}
