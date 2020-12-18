package daily;

import java.util.Arrays;

/**
 * @FileName: No389.java
 * @Description: 找不同
 * @Author: admin
 * @Date: 2020/12/18 9:47
 */
public class No389 {

    public char findTheDifference(String s, String t) {
        // t随机重排
        if (s == null || s.length() == 0) {
            return t.charAt(0);
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = String.valueOf(chars);
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        t = String.valueOf(chars1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return t.charAt(i);
            }
        }
        return t.charAt(t.length() - 1);
    }

    public char find(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.charAt(0);
        }
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }
        letters[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] < 0) {
                return (char) (i + 'a');
            }
        }
        return '#';
    }

}
