package myanswer.string.easy;

import java.util.Arrays;

/**
 * @FileName: No1160.java
 * @Description: 拼写单词
 * @Author: camille
 * @Date: 2020/11/25 19:38
 */
public class No1160 {

    public int countCharacters(String[] words, String chars) {
        // 19:22开始 19:44结束
        // 0位置表示a
        int res = 0;
        int[] letters = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            letters[chars.charAt(i) - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            int[] copy = {};
            copy = Arrays.copyOf(letters, letters.length);
            boolean remeber = true;
            for (int j = 0; j < n; j++) {
                if (copy[words[i].charAt(j) - 'a'] > 0) {
                    copy[words[i].charAt(j) - 'a']--;
                } else {
                    remeber = false;
                    break; // 不用看了
                }
            }
            if (remeber) {
                res += n;
            }
        }
        return res;
    }

    // 不用拷贝，直接新建数组来优化
    public int countCharacters1(String[] words, String chars) {
        // 19:51结束
        // 0位置表示a
        int res = 0;
        int[] letters = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            letters[chars.charAt(i) - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();

            int[] copy = new int[26];
            boolean remeber = true;
            for (int j = 0; j < n; j++) {
                copy[words[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (copy[j] > letters[j]) {
                    remeber = false;
                    break;
                }
            }
            if (remeber) {
                res += n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No1160 no1160 = new No1160();
        String[] words = {"cat", "bt", "hat", "tree", "ata"};
        int ans = no1160.countCharacters1(words, "atach");
        System.out.println(ans);
    }

}
