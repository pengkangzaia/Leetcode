package myanswer.slidingwindow;

/**
 * @FileName: No424.java
 * @Description: 替换后的最长重复字符
 * @Author: admin
 * @Date: 2021/2/2 9:57
 */
public class No424 {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;

        int[] freq = new int[26];
        int left = 0, right = 0; // 滑动窗户左右边界
        int maxCount = 0; // 当前窗口内出现次数最多的字符的出现次数
        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            right++;
            if (right - left > maxCount + k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
