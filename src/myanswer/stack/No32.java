package myanswer.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @FileName: No32.java
 * @Description: 最长有效的括号
 * @Author: admin
 * @Date: 2020/10/30 14:28
 */
public class No32 {

    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 弹出栈顶左括号以和右括号作匹配
                // 如果栈只有一个元素，弹出后将最近的右括号入栈
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 右括号入栈
                } else {
                    // 栈顶还有左括号
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No32 no32 = new No32();
        int ans = no32.longestValidParentheses("()(()()");
        System.out.println(ans);
    }

}
