package mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @FileName: MostCommonWord.java
 * @Description: MostCommonWord.java类说明
 * @Author: camille
 * @Date: 2021/1/4 21:02
 */
public class MostCommonWord {


    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("\\W+");
        // 不能用增强for循环
        for (int i = 0; i < words.length; i++) {
            char end = words[i].charAt(words[i].length() - 1);
            if (!(end <= 'z' && end >= 'a')) {
                // 注意是substring不是subString
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        String ans = "";
        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > res) {
                ans = key;
                res = map.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String ans = mostCommonWord.mostCommonWord("a,a,a,c,c,c,b,b,b,b,b", new String[]{"hit"});
        System.out.println(ans);
    }

}
