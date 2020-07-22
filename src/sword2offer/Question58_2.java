package sword2offer;

public class Question58_2 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String substring = s1.substring(1, s1.length()) + s2.substring(0, 1);
        System.out.println(substring);
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || s.length() < n) {
            return s;
        }
        String ans = s.substring(n, s.length()) + s.substring(0, n);

        return ans;
    }

    // 牛客版
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        int index = n % len;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < len; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < index; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
