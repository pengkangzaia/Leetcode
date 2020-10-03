package myanswer.string.substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class No76 {

    public String minWindow(String s, String t) {

        if (t == null || s == null || s.length() < t.length()) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        String substring = "";
        for (int i = 0; i < s.length(); i++) {

            // 没有考虑一个字符串种有相同字母的情况
            HashSet<Character> set = new HashSet<>();
            for (int k = 0; k < t.length(); k++) {
                set.add(t.charAt(k));
            }

            for (int j = i; j <= s.length(); j++) {
                if (set.size() != 0) {
                    if (j < s.length()) {
                        set.remove(s.charAt(j));
                    }
                } else {
                    if (min > j - i) {
                        // set的大小为 0 后，j又加了一次
                        substring = s.substring(i, j);
                        min = j - i;
                        break;
                    }
                }
            }
        }
        return substring;
    }

    HashMap<Character, Integer> check = new HashMap<>();
    HashMap<Character, Integer> curr = new HashMap<>();

    public String minWindow1(String s, String t) {

        // 存check，设置双指针，遍历字符串s，遍历过程中判断最小窗口
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            check.put(c, check.getOrDefault(c, 0) + 1); //这里要加1的
        }

        int minWindow = Integer.MAX_VALUE, l = 0, r = -1, ansL = -1, ansR = -1;

        while (r < s.length()) {
            r++;
            // char c = s.charAt(r); // r可能会越界，所以这里不能采用这种方式
            if (r < s.length() && check.containsKey(s.charAt(r))) {
                curr.put(s.charAt(r), curr.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (satisfy() && l <= r) {
                if (r - l + 1 < minWindow) {
                    minWindow = r - l + 1;
                    ansL = l;
                    ansR = l + minWindow; // r + 1，substring取子字符串是左闭右开的
                }
                if (check.containsKey(s.charAt(l))) {
                    curr.put(s.charAt(l), curr.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansR == -1 ? "" : s.substring(ansL, ansR);

    }

    private boolean satisfy() {

        Iterator<Character> iterator = check.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer value = check.get(key);
            if (curr.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        No76 no76 = new No76();
        String ans = no76.minWindow1("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }

}
