package sword2offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Question50 {

    // 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                int count = hashMap.get(chars[i]);
                count++;
                hashMap.put(chars[i], count);
            } else {
                hashMap.put(chars[i], 1);
            }
        }
        for (Character key : hashMap.keySet()) {
            if(hashMap.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }

}
