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
        /*int ans = no171.titleToNumber1("ZY");
        System.out.println(ans);*/
        System.out.println(no171.titleToNumber1("A"));
        System.out.println(no171.titleToNumber1("AB"));
    }



    public int titleToNumber1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (int) (Math.pow(26, (chars.length - 1 - i))) * (chars[i] - 'A' + 1);
        }
        return res;
    }


}
