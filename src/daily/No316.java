package daily;

import java.util.Stack;

/**
 * @FileName: No316.java
 * @Description: 去除重复字母
 * @Author: camille
 * @Date: 2020/12/20 12:56
 */
public class No316 {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = n - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            i--;
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (!stack.contains(c)) {
                stack.push(c);
            } else if (c >= stack.peek()) {
                continue;
            } else {
                int search = stack.search(c);
                stack.remove(stack.size() - search);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No316 no316 = new No316();
        String ans = no316.removeDuplicateLetters("cbacdcbc");
        System.out.println(ans);
    }


}
