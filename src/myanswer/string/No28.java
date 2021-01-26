package myanswer.string;

public class No28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        } else if (haystack == null || haystack.length() == 0) {
            return -1;
        } else {
            int i = 0;
            int len = haystack.length();
            // 如果haystack剩下的长度不够的话，直接不用判断。
            // 剩下的字符串长度为 len - i
            while (i < len && (len - i) >= needle.length()) {
                int j = 0;
                int cur = i;
                while (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == needle.length()) {
                        return cur;
                    }
                }
                i = cur;
                i++;
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        No28 no28 = new No28();
        int ans = no28.strStr("abc", "abc");
        System.out.println(ans);
    }

}
