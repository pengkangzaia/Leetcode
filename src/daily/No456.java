package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @FileName: No456.java
 * @Description: 132模式
 * @Author: admin
 * @Date: 2021/3/24 9:44
 */
public class No456 {

    /**
     * 给定一个整数序列：a1, a2, ..., an，
     * 一个132模式的子序列ai, aj, ak被定义为：
     * 当 i < j < k 时，ai < ak < aj。
     * 设计一个算法，当给定有n 个数字的序列时，
     * 验证这个序列中是否含有132模式的子序列。
     * <p>
     * 注意：n 的值小于15000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/132-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        // 最小值数组
        int[] minNum = new int[n];
        minNum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minNum[i] = Math.min(minNum[i - 1], nums[i]);
        }

        // 从后往前单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > minNum[i]) {
                // 需要栈中元素绝对大于minNum[i]
                while (!stack.isEmpty() && stack.peek() <= minNum[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        No456 no456 = new No456();
        // [-2,1,2,-2,1,2]
        // 最小值数组+从后往前遍历获取单调递增栈
        System.out.println(no456.find132pattern(new int[]{2, 3, 1, 2}));
    }




}
