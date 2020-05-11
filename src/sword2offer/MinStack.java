package sword2offer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.add(x);
        if (stack2.empty() || x <= stack2.peek()) {
            stack2.add(x);
        }
    }

    public void pop() {
        int p = stack1.pop();
        if (stack2.peek().equals(p)) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
