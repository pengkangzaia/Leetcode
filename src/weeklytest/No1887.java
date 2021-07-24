package weeklytest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 彭康
 * @create 2021-06-09 22:15
 **/
public class No1887 {

    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            heap.offer(num);
        }
        int n = nums.length;
        int maxCount = 0;
        int maxValue;
        int res = 0;
        while (true) {
            // 取出最大值
            maxValue = heap.poll();
            maxCount++;
            while (heap.size() != 0 && heap.peek() == maxValue) {
                heap.poll();
                maxCount++; // 记录最大值个数
            }
            // 判断个数
            if (maxCount == n) {
                return res;
            }
            // 取出次大值
            int nextLargeValue = heap.poll();
            // 增加res
            res += maxCount;
            for (int i = 1; i <= maxCount + 1; i++) {
                heap.offer(nextLargeValue);
            }
            maxCount = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        No1887 no1887 = new No1887();
        int ans = no1887.reductionOperations1(nums);
        System.out.println(ans);
    }

    public int reductionOperations1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int idx = n - 1;
        int res = 0;
        int endIdx = 0;
        while (endIdx < n && nums[endIdx] == nums[0]) {
            endIdx++;
        }
        while (idx >= endIdx) {
            while (idx >= 1 && nums[idx] == nums[idx - 1]) {
                idx--;
            }
            res += n - idx;
            idx--;
        }
        return res;
    }



}
