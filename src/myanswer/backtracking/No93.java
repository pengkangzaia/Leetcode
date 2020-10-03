package myanswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No93.java
 * @Description: 给一个数字字符串，复原IP地址
 * @Author: admin
 * @Date: 2020/9/24 19:24
 */
public class No93 {

    public List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder ip = new StringBuilder();
        // 查找四个分段点，每个点从1开始，保证下面的substring有值
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            int num1 = Integer.parseInt(s.substring(0, a));
                            int num2 = Integer.parseInt(s.substring(a, a + b));
                            int num3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int num4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            if (num1 <= 255 && num2 <= 255 && num3 <= 255 && num4 <= 255) {
                                ip.append(num1).append('.').append(num2).append('.').append(num3).append('.').append(num4);
                                if (ip.length() == s.length() + 3) {
                                    res.add(new String(ip));
                                }
                                ip.delete(0, ip.length());
                            }
                        }

                    }
                }
            }
        }
        return res;
    }




    public static void main(String[] args) {
        No93 no93 = new No93();
        List<String> res = no93.restoreIpAddresses("010010");
        for (String s : res) {
            System.out.println(s);
        }
    }


}
