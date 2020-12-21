package daily;

import java.util.Stack;

/**
 * @FileName: No316.java
 * @Description: 去除重复字母
 * @Author: admin
 * @Date: 2020/12/21 11:36
 */
public class No316 {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!stack.contains(c)) {
                if (stack.isEmpty() || stack.peek() < c) {
                    stack.push(c);
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                    stack.pop();
                }
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
    // 栈顶 > 当前 z>b  zbcb   z

    public static void main(String[] args) {
        No316 no316 = new No316();
        String ans = no316.removeDuplicateLetters("zcbcb");
        System.out.println(ans);
    }


}
