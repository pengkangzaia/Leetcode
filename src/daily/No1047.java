package daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No1047.java
 * @Description: 删除字符串中的所有相邻重复项
 * @Author: admin
 * @Date: 2021/3/9 9:47
 */
public class No1047 {

    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || stack.peek() != chars[i]) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }


}
