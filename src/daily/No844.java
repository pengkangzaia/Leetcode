package daily;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @FileName: No844.java
 * @Description: 比较含退格的字符串
 * @Author: peng.kang
 * @Date: 2020/10/19 9:34
 */
public class No844 {

    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return (s == null) && (t == null);
        }
        s = edit(s);
        t = edit(t);
        return s.equals(t);
    }

    private String edit(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '#') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No844 no844 = new No844();
        boolean b = no844.backspaceCompare("ab##", "c#d#");
        System.out.println(b);
    }

}
