package bishi;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question5 {

    public Character findChar(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        int max = Integer.MIN_VALUE;
        char temp = chars[0];
        for (Character character : map.keySet()) {
            if (map.get(character) > max) {
                max = map.get(character);
                temp = character;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();
        Character ans = question5.findChar("babacsdw");
        System.out.println(ans);
    }

}
