package MyAnswer.string;

import java.util.HashMap;

public class No290 {

    public boolean wordPattern(String pattern, String str) {
        // corner case 处理
        if (pattern == null) {
            return false;
        } else if (str == null) {
            return false;
        } else if (pattern.length() != str.split(" ").length) {
            return false;
        } else {
            String[] strings = str.split(" ");
            char[] chars = pattern.toCharArray();
            HashMap<Character, String> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                // 需要判断 p -> str 和 str -> p 两个双映射
/*            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            } else {
                map.put(chars[i], strings[i]);
            }*/
                if(map.get(chars[i]) == null) {
                    if (map.containsValue(strings[i])) {
                        return false;
                    }
                    map.put(chars[i], strings[i]);
                } else {
                    if (!map.get(chars[i]).equals(strings[i])) {
                        return false;
                    }
                }
            }
            return true;
        }



    }

}
