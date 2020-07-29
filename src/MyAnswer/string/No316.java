package MyAnswer.string;

import java.util.Stack;

public class No316 {
    // 自己实现的，有错误
    public String removeDuplicateLetters(String s) {
        // 新字符和栈顶元素比较
        // 如果比栈顶元素小，且新字符后面还有栈顶元素，则把栈顶元素弹出，新字符压栈
        // 如果比栈顶元素大，则直接压栈
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        // 先把所有元素压栈处理
        for (int i = chars.length - 1; i >= 0; i--) {
            stack.push(chars[i]);
        }
        Stack<Character> res = new Stack<>();
        while (!stack.empty()) {
            char c = stack.pop();
            if (stack.isEmpty()) {
                if (!res.contains(c)) {
                    res.push(c);
                }
                break;
            }
            if (!(c > stack.peek() && stack.contains(c))) {
                res.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pop());
        }
        return sb.reverse().toString();
    }

    // leetcode 上的
    public String removeDuplicateLetters1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c))
                continue;
            // String.indexOf(String str，int index)
            //从index的地方开始找，返回第一次出现的索引
            while (!stack.isEmpty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        }
        char[] chars = new char[stack.size()];
        // stack.grt(0)表示的是stack的栈低元素
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        No316 no316 = new No316();
        String ans = no316.removeDuplicateLetters1("cbacdcbc");
        System.out.println(ans);
    }

}
