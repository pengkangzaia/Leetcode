package MyAnswer.string;

public class No5 {

    private int len = 0;
    private int index = 0;
    private char[] chars;

    // 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s; // 不能return null，空字符应该返回空字符串
        }
        // 两种情况
        // 有中间字符的(aba)和没有中间字符的(aa)
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            helper(i, i);
            helper(i, i + 1);
        }
        return s.substring(index, index + len);
    }

    private void helper(int i, int j) {
        while (i >= 0 && j <= chars.length - 1 && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (len < (j - 1) - (i + 1) + 1) {
            index = i + 1;
            len = (j - 1) - (i + 1) + 1;
        }
    }

    public static void main(String[] args) {
        No5 no5 = new No5();
        String ans = no5.longestPalindrome("aaaccssdwd");
        System.out.println(ans);
    }


}
