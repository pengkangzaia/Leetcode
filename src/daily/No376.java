package daily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @FileName: No376.java
 * @Description: No376.java类说明
 * @Author: camille
 * @Date: 2020/12/12 20:46
 */
public class No376 {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if (stack.size() == 1) {
                if (stack.peek() != nums[i]) {
                    stack.push(nums[i]);
                }
            } else {
                int prev = stack.pop();
                int pp = stack.pop();
                if (prev == nums[i]) {
                    stack.push(pp);
                    stack.push(nums[i]);
                } else if ((prev > nums[i] && pp > prev) || (prev < nums[i] && pp < prev)) {
                    stack.push(pp);
                    stack.push(nums[i]);
                } else if ((prev > nums[i] && pp < prev) || (prev < nums[i] && pp > prev)) {
                    stack.push(pp);
                    stack.push(prev);
                    stack.push(nums[i]);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        No376 no376 = new No376();
        int[] nums = {0, 0};
        int ans = no376.wiggleMaxLength(nums);
        System.out.println(ans);
    }

    public int wiggleMaxLength1(int[] nums) {
        // 官方题解自己实现版
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int preDiff = nums[0] - nums[1];
        int res = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int diff = nums[i - 1] - nums[i];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }


}
