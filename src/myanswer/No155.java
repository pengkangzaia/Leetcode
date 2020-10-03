package myanswer;

import java.util.ArrayList;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) -- 将元素 x 推入栈中。
//        pop() -- 删除栈顶的元素。
//        top() -- 获取栈顶元素。
//        getMin() -- 检索栈中的最小元素。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/min-stack
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class No155 {
    private ArrayList<Integer> a;
    /** initialize your data structure here. */
    public No155() {
        this.a = new ArrayList<>();
    }

    public void push(int x) {
        this.a.add(x);
    }

    public void pop() {
        this.a.remove(a.size()-1);
    }

    public int top() {
        return this.a.get(a.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : this.a) {
            min = integer > min ? min : integer;
        }
        return min;
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
