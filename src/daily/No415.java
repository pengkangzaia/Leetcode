package daily;

import java.util.Collections;

public class No415 {

    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 & j >= 0) {
            int tem = (n1[i] - '0' + n2[j] - '0' + carry - 10);
            if (tem >= 0) {
                sb.append(tem);
                carry = 1;
            } else {
                sb.append(n1[i] - '0' + n2[j] - '0' + carry);
                carry = 0;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (n1[i] - '0' + carry >= 10) {
                sb.append(n1[i] - '0' + carry - 10);
                carry = 1;
            } else {
                sb.append(n1[i] - '0' + carry);
                carry = 0;
            }
            i--;
        }
        while (j >= 0) {
            if (n2[j] - '0' + carry >= 10) {
                sb.append(n2[j] - '0' + carry - 10);
                carry = 1;
            } else {
                sb.append(n2[j] - '0' + carry);
                carry = 0;
            }
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // leetcode 上的解法，语法很简洁
    public String addStrings1(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int i = n1.length - 1;
        int j = n2.length - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i>=0 || j>=0) {
            int c1 = i >= 0 ? n1[i] - '0' : 0;
            int c2 = j >= 0 ? n2[j] - '0' : 0;
            int tem = c1 + c2 + carry;
            carry = tem / 10;
//            int add = tem >= 10 ? tem - 10 : tem; //还可以更简洁 用 tem % 10
//            res.append(add);
            res.append(tem % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(carry);
        return res.reverse().toString();
    }


    public static void main(String[] args) {

        No415 no415 = new No415();
        String ans = no415.addStrings1("567", "456");
        System.out.println(ans);

    }


}
