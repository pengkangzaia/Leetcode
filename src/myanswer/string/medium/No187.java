package myanswer.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @FileName: No187.java
 * @Description: 重复的DNA序列
 * @Author: camille
 * @Date: 2021/3/1 22:51
 */
public class No187 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                res.add(key);
            }
        }
        return res;
    }


}
