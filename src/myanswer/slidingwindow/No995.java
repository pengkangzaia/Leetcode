package myanswer.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No995.java
 * @Description: K 连续位的最小翻转次数
 * @Author: admin
 * @Date: 2021/2/18 14:33
 */
public class No995 {

    public int minKBitFlips(int[] nums, int K) {
        // 使数组没有0
        // 贪心 + 滑动窗口
        // 超时优化：队列记录要翻转的元素下标
        int res = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= nums.length - K; i++) {
            while (!queue.isEmpty() && queue.peek() + K <= i) {
                queue.poll();
            }
            if (queue.size() % 2 == 1 && nums[i] == 1) {
                // nums[i]要被翻转为0，所以这里要加入队列以表示需要翻转
                queue.offer(i);
                res++;
            } else if (queue.size() % 2 == 0 && nums[i] == 0) {
                queue.offer(i);
                res++;
            }
        }
        for (int i = nums.length - K + 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() + K <= i) {
                queue.poll();
            }
            if (queue.size() % 2 == 0 && nums[i] == 0) {
                return -1;
            } else if (queue.size() % 2 == 1 && nums[i] == 1) {
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
        No995 no995 = new No995();
        int ans = no995.minKBitFlips(nums, 3);
        System.out.println(ans);
    }


}
