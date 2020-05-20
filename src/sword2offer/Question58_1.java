package sword2offer;

public class Question58_1 {

    public static void main(String[] args) {

        String s = "the sky is blue";
        String[] ans1 = s.split(" ");
        for (String s1 : ans1) {
            System.out.println(s1);
        }
        String ans = reverseWords(s);
        System.out.println(ans);

    }

    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
