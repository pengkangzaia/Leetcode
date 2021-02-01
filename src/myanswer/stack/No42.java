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

    // 接雨水，暴力解法。对每个元素，分别从当前元素向左，和从当前元素向由查找最大的元素然后差值
    public int trap1(int[] height) {
        int n = height.length;
        int ans = 0;
        // 最左边和最右边元素显然不可能是中心元素
        for (int i = 1; i < n - 1; i++) {
            // 每一个元素都有对应的左边最大值和右边最大值
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                // 包含当前元素
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < n; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    // 方法2，空间换时间
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = height[0];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        max_right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }
        for (int i = 1; i <= n - 2; i++) {
            // 最小值一定要大于等于当前元素
            ans = Math.min(max_left[i - 1], max_right[i + 1]) - height[i];
        }
        return ans;
    }

}
