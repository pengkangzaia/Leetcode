package MyAnswer.math;

public class No7 {

    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        boolean isNegative = false;
        int start = 0;
        if (chars[0] == '-') {
            isNegative = true;
            start++;
        }
        boolean isContinueZero = chars[chars.length-1] == '0';
        StringBuilder sb = new StringBuilder();
        int end = chars.length - 1;
        while (end >= start) {
            while (isContinueZero) {
                end--;
                if (end < 0) break;
                if (chars[end] != '0') {
                    isContinueZero = false;
                }
            }
            if (end < 0) break;
            sb.append(chars[end]);
            end--;
        }
        if (sb.length() == 0) {
            return 0;
        }
        return isNegative ? -1 * Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int ans = reverse(-0);
        System.out.println(ans);
    }

}
