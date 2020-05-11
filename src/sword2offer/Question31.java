package sword2offer;

import java.util.Stack;

public class Question31 {

    public static void main(String[] args) {
        Question31 question31 = new Question31();
        int[] pushed = {2, 1, 0};
        int[] poped = {1, 2, 0};
        boolean ans = question31.validateStackSequences(pushed, poped);
        System.out.println(ans);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        // 建一个栈
        // 按pushed数组元素压栈
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i <= pushed.length - 1; i++) {
            if (pushed[i] != popped[popIndex]) {
                // 待压栈元素（压栈成功后的第一个元素）不等于需要出栈的第一个元素
                while (!stack.empty() && stack.peek() == popped[popIndex]) {
                    // 此处还需要考虑当前栈的栈顶元素与popped的当前元素不匹配
                    // 如果匹配，则要弹出stack中的元素
                    stack.pop();
                    popIndex++;
                }
                stack.push(pushed[i]);
            } else {
                popIndex++;
            }
        }
        while (!stack.empty()) {
            if (stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

}
