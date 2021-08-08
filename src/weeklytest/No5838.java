package weeklytest;

/**
 * @author 彭康
 * @create 2021-08-08 11:15
 **/
public class No5838 {


    public boolean isPrefixString(String s, String[] words) {
        char[] chars = s.toCharArray();
        int idx = 0;
        for (String word : words) {
            int j = 0;
            while (j < word.length() && idx < chars.length && word.charAt(j) == chars[idx]) {
                j++;
                idx++;
            }
            if (j != word.length()) {
                return false;
            }
            if (idx == chars.length) {
                break;
            }
        }
        return idx == chars.length;
    }


    public static void main(String[] args) {
        No5838 no5838 = new No5838();
        String[] words = {"i","love","leetcode","apples"};
        boolean ans = no5838.isPrefixString("iloveleetcode", words);
        System.out.println(ans);
    }



}
