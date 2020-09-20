/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package MyAnswer.string.easy;

/**
 * @FileName: No67.java
 * @Description: No67.java类说明
 * @Author: kang.peng
 * @Date: 2020/9/20 22:10
 */
public class No67 {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        // 从末位开始相加
        for (int i = 0; i < n; i++) {
            carry = carry + (i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0);
            carry = carry + (i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0);
            res.append(carry % 2);
            carry = carry / 2;
        }
        if (carry >= 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        No67 no67 = new No67();
        String s = no67.addBinary("11", "1");
        System.out.println(s);
    }


}
