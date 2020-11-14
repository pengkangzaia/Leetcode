package myanswer.queue;

import myanswer.linkedlist.hard.No23;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No239.java
 * @Description: 滑动窗口最大值
 * @Author: admin
 * @Date: 2020/11/14 10:19
 */
public class No239 {

    // 可以利用双端队列维护一个单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 入队列
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            // 出队列
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            // i是递增的，所以一旦满足，则都满足。
            if(i+1 >= k){
                // 赋值
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        No239 no239 = new No239();
        int[] nums = {1,-1};
        int[] ans = no239.maxSlidingWindow(nums, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


}
