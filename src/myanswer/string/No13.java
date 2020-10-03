package myanswer.string;

import java.util.Arrays;
import java.util.HashMap;

public class No13 {

    private HashMap<Character, Integer> hashMap = new HashMap<>();

    {
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
    }

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return hashMap.getOrDefault(s.charAt(0), 0);
        }

        char prev = s.charAt(0);
        char curr;
        int res = hashMap.get(prev);
        for (int i = 1; i < s.length(); i++) {
            curr = s.charAt(i);
            int c = hashMap.get(curr);
            int p = hashMap.get(prev);
            if (p < c) {
                res = res - p + c - p;
            } else {
                res += c;
            }
            prev = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"follower","flow","flight"};
        Arrays.sort(strs);
        for (String str : strs) {
            System.out.println(str);
        }

    }

}
