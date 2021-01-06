package daily;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @FileName: No239.java
 * @Description: 滑动窗口最大值
 * @Author: camille
 * @Date: 2021/1/2 12:38
 */
public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && list.get(0) < nums[i]) {
                list.removeLast();
            }
            list.offer(nums[i]);
            // 还需要判断list的大小，如果list里面存的数大于k，就要弹出
            while (list.size() >= k) {
                list.removeFirst();
            }
            if (i - k + 1 >= 0) {
                res.offer(list.peek());
            }
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        No239 no239 = new No239();
        int[] ans = no239.maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(ans));
    }


}
