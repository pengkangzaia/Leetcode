package myanswer;

import java.util.ArrayList;
import java.util.Stack;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
// 最小栈
public class No155 {
//    private ArrayList<Integer> a;
    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public No155() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else if (min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        Integer top = stack.pop();
        if (top.equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
      //  ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
      //  [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
        No155 n = new No155();
        n.push(2);
        n.push(0);
        n.push(3);
        n.push(0);
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
    }

}
