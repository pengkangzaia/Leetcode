package daily;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No239.java
 * @Description: 滑动窗口最大值
 * @Author: camille
 * @Date: 2021/1/2 12:38
 */
public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            list.addLast(i);
            // 判断队首是否有效
            if (list.peek() <= i - k) {
                list.poll();
            }
            if (i - k + 1 >= 0) {
                res.offer(nums[list.peek()]);
            }
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        No239 no239 = new No239();
        int[] ans = no239.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }


}
