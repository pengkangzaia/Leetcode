package myanswer.stack;

import java.util.Stack;

/**
 * @FileName: No42.java
 * @Description: 接雨水
 * @Author: admin
 * @Date: 2020/10/30 9:55
 */
public class No42 {

    public int trap(int[] height) {
        Stack<Integer> location = new Stack<>();
        int res = 0;
        int tem = 0;
        for (int i = 0; i < height.length; i++) {
            if (location.isEmpty()) {
                location.push(i);
            } else if (height[i] >= height[location.peek()]) {
                int index = location.pop();
                res += (i - index - 1) * height[index] - tem;
                tem = 0;
                location.push(i);
            } else {
                tem += height[i];
            }
        }
        return res;

        //    int sum = 0;
        //    Stack<Integer> stack = new Stack<>();
        //    int current = 0;
        //    while (current < height.length) {
        //        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        //        while (!stack.empty() && height[current] > height[stack.peek()]) {
        //            int h = height[stack.peek()]; //取出要出栈的元素
        //            stack.pop(); //出栈
        //            if (stack.empty()) { // 栈空就出去
        //                break;
        //            }
        //            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
        //            int min = Math.min(height[stack.peek()], height[current]);
        //            sum = sum + distance * (min - h);
        //        }
        //        stack.push(current); //当前指向的墙入栈
        //        current++; //指针后移
        //    }
        //    return sum;

    }

    public static void main(String[] args) {
        No42 no42 = new No42();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = no42.trap(nums);
        System.out.println(ans);
    }

}
