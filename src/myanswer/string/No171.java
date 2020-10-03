package myanswer.string;

public class No171 {

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        int count = 0;
        for (int i = len-1; i >= 0; i--) {
            char c = s.charAt(i);
            int temp = (c - 'A' + 1);
            res += Math.pow(26, count) * temp;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        No171 no171 = new No171();
        int ans = no171.titleToNumber("ZY");
        System.out.println(ans);
    }


}
