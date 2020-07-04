package MyAnswer.array.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No739 {

    public static void main(String[] args) {
        No739 no739 = new No739();
        int[] ans = no739.dailyTemperatures(new int[]{89});
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> stack = new LinkedList<>();
        int n = t.length;
        int[] res = new int[n];
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            // 此处为大于等于，比如今天是47，明天也是47，这不算气温升高，要将栈中的值弹出
            while (!stack.isEmpty() && t[i] >= t[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

}
