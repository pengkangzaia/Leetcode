package MyAnswer.string.substring;

import java.util.HashSet;

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

    public static void main(String[] args) {
        No76 no76 = new No76();
        String ans = no76.minWindow("aa", "aa");
        System.out.println(ans);
    }

}
