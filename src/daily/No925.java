package daily;

import java.util.Stack;

/**
 * @FileName: No925.java
 * @Description: 长按键入
 * @Author: admin
 * @Date: 2020/10/21 14:02
 */
public class No925 {

    public boolean isLongPressedName(String name, String typed) {
        // name原名 typed键盘输入
        if (name == null || typed == null) {
            return name == null && typed == null;
        }
        if (name.length() > typed.length()) {
            return false;
        }
        // 用栈好像方便一点？
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < typed.length(); i++) {
            stack.push(typed.charAt(i));
        }
        int idx = name.length() - 1;
        char pre = name.charAt(idx);
        while (!stack.isEmpty()) {
            if (idx >= 0 && stack.peek() == name.charAt(idx)) {
                pre = name.charAt(idx);
                stack.pop();
                idx--;
            } else if (pre == stack.peek()) {
                // 重复的
                stack.pop();
            } else {
                return false;
            }
        }
        return idx < 0;
    }

    public static void main(String[] args) {
        No925 no925 = new No925();
        // "ppyplrza"
        //"pyypllrza"
        boolean ans = no925.isLongPressedName("ppyplrza", "pyypllrza");
        System.out.println(ans);
    }


}
