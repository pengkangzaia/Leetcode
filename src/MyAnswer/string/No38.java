package MyAnswer.string;

public class No38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int start = 0;
            int end = 0;
            while (start <= pre.length()-1) {
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;
                    /*if (end >= pre.length()) {
                        break;
                    }*/
                }
                temp.append((end-start));
                temp.append(pre.charAt(start));
                start = end;
            }
            pre = temp.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        No38 no38 = new No38();
        String ans = no38.countAndSay(5);
        System.out.println(ans);
    }

}
