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
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // 左边界的高度
                    Integer stackTop = stack.peek();
                    res += (Math.min(height[stack.peek()], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
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


        // public class Solution {
        //    public int trap(int[] height) {
        //        if (height == null) {
        //            return 0;
        //        }
        //        Stack<Integer> stack = new Stack<>();
        //        int ans = 0;
        //        for (int i = 0; i < height.length; i++) {
        //            // 栈顶元素小于当前元素，出栈
        //            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
        //                int curIdx = stack.pop();
        //                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
        //                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
        //                    stack.pop();
        //                }
        //                if (!stack.isEmpty()) {
        //                    int stackTop = stack.peek();
        //                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
        //                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
        //                    // i - stackTop - 1 是雨水的宽度。
        //                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
        //                }
        //            }
        //            stack.add(i);
        //        }
        //        return ans;
        //    }
        //}

    }

    public static void main(String[] args) {
        No42 no42 = new No42();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = no42.trap(nums);
        System.out.println(ans);
    }

}
