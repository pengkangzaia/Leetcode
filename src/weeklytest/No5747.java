package weeklytest;

import java.math.BigInteger;

public class No5747 {

    // 将字符串拆分为递减的连续值

    public boolean splitString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        for (int i = 0; i <= n - 2; i++) {
            BigInteger firstNum = new BigInteger(s.substring(0, i+1));
            if (isSplitAble(firstNum, i + 1, s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSplitAble(BigInteger firstNum, int start, String s) {
        if (start >= s.length()) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            BigInteger secondNum = new BigInteger(s.substring(start, i+1));
            BigInteger subtract = firstNum.subtract(secondNum);
            if (subtract.equals(BigInteger.ONE)) {
                // 继续递归
                boolean b = isSplitAble(secondNum, i + 1, s);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No5747 no5747 = new No5747();
        boolean ans = no5747.splitString("99999999999999999998");
        System.out.println(ans);
    }


}
