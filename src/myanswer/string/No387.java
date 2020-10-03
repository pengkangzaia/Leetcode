package myanswer.string;

public class No387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;

        int i = s.length() - 1;
        int[] count = new int[26];
        while (i >= 0) {
            count[s.charAt(i--) - 'a']++;
            //i--;
        }
        i = 0;
        while (i < s.length()) {
            // 第一个不重复的字符
            if (count[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No387 no387 = new No387();
        int ans = no387.firstUniqChar("sqwfws");
        System.out.println(ans);
    }

}
