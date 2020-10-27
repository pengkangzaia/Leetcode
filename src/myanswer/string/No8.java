package myanswer.string;

/**
 * @FileName: No8.java
 * @Description: 字符串转整数
 * @Author: admin
 * @Date: 2020/10/26 19:40
 */
public class No8 {

    /**
     * 请你来实现一个atoi函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     * <p>
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
     * 则你的函数不需要进行转换，即无法进行有效转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     */
    public int myAtoi(String s) {
        // 去除首尾空白字符
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int idx = 0;
        int len = s.length();
        // 仅包含空白字符
        if (len == 0) {
            return 0;
        }
        long res = 0;
        int flag = 1;
        if (s.charAt(idx) == '-') {
            flag *= -1;
            idx++;
        }
        while (idx < len) {

        }


        return (int) res;
    }

    public static void main(String[] args) {
        String s = "    ";
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
    }


}
