package myanswer.string;

/**
 * @FileName: No557.java
 * @Description: No557.java类说明
 * @Author: camille
 * @Date: 2020/10/25 15:53
 */
public class No557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                res.append(sb.reverse().toString());
                sb = new StringBuilder();
                res.append(chars[i]);
            } else {
                sb.append(chars[i]);
            }
        }
        res.append(sb.reverse().toString());
        return res.toString();
    }

    public static void main(String[] args) {
        No557 no557 = new No557();
        String ans = no557.reverseWords("Let's take LeetCode contest");
        System.out.println(ans);
    }


}
