package myanswer.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @FileName: No394.java
 * @Description: 字符串解码
 * @Author: camille
 * @Date: 2020/10/29 21:26
 */
public class No394 {

    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                // 重复次数可能大于10
                int count = 0;
                while (Character.isDigit(c)) {
                    count = count * 10 + (c - '0');
                    index++;
                    c = s.charAt(index);
                }
                counts.push(count);
            } else if (c == '[') {
                result.push(res.toString());
                res = new StringBuilder();
                index++;
            } else if (c == ']') {
                // 前面存的
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    // 当前两个括号之间的字符串，要重复i次
                    temp.append(res);
                }
                res = temp;
                index++;
            } else {
                res.append(c);
                index++;
            }
        }
        return res.toString();
    }

}
