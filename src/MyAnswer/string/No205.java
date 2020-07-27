package MyAnswer.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class No205 {

    // 第一次尝试：暴力法
    // 题目要求保留顺序！！！白写了
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> hashMapS = new HashMap<>();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        //int i = 0;
        //int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (!hashMapS.containsKey(s.charAt(i))) {
                hashMapS.put(s.charAt(i), 1);
            } else {
                hashMapS.put(s.charAt(i), hashMapS.get(s.charAt(i)) + 1);
            }
            if (!hashMapT.containsKey(t.charAt(i))) {
                hashMapT.put(t.charAt(i), 1);
            } else {
                hashMapT.put(t.charAt(i), hashMapT.get(t.charAt(i)) + 1);
            }
        }
        ArrayList<Integer> listS = new ArrayList<>();
        ArrayList<Integer> listT = new ArrayList<>();
        for (Character c : hashMapS.keySet()) {
            listS.add(hashMapS.get(c));
        }
        for (Character c : hashMapT.keySet()) {
            listT.add(hashMapT.get(c));
        }
        Collections.sort(listS);
        Collections.sort(listT);
        if (listS.size() != listT.size()) {
            return false;
        }
        for (int i = 0; i < listT.size(); i++) {
            if (!listS.get(i).equals(listT.get(i))) {
                return false;
            }
        }
        return true;

    }

    // 第二次尝试：用hashmap判断
    // tobe continue
    public boolean isIsomorphic1(String s, String t) {
//        HashMap<Character, Integer> mapS = new HashMap<>();
//        HashMap<Character, Integer> mapT = new HashMap<>();
//        int countS = 1;
//        int countT = 1;
//        for (int i = 0; i < s.length(); i++) {
//            if(!mapS.containsKey(s.charAt(i))) {
//                mapS.put(s.charAt(i), countS);
//                countS++;
//            }
//            if(!mapT.containsKey(t.charAt(i))) {
//                mapT.put(t.charAt(i), countT);
//                countT++;
//            }
//        }
//        return false;
        HashMap<Character, Character> map = new HashMap<>();
        //boolean flag = true;
        for (int i=0; i<= s.length()-1; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.get(sc) == null) {
                // 这里还需要一步，判断map里有没有tc这个字符，如果有则报错
                if (map.containsValue(tc)) {
                    return false;
                }
                map.put(sc, tc);
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }
        }
        return true;
    }

}
