package myanswer.string;

/**
 * @FileName: No8.java
 * @Description: 字符串转换整数
 * @Author: admin
 * @Date: 2020/10/26 19:40
 */
public class No8 {

    // 注意前导空格，符号位的判断，第一个字符不是数字直接返回，int的溢出问题
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        int n = s.length();
        // 取出前导空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index == n) {
            return 0; // 全为0
        }
        // 判断符号位
        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        } else if (!Character.isDigit(s.charAt(index))) {
            // 如果不是数字。则直接返回0
            return 0;
        }
        int res = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int num = s.charAt(index) - '0';
            // 注意数据溢出
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + num;
            index++;
        }
        return isNegative ? -1 * res : res;
    }

    public static void main(String[] args) {
        String s = "    ";
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
    }


}
