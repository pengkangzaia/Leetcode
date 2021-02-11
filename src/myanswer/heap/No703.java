package myanswer.heap;

import java.util.PriorityQueue;

/**
 * @FileName: No703.java
 * @Description: 数据流中的第 K 大元素
 * @Author: admin
 * @Date: 2021/2/11 10:52
 */
public class No703 {

    class KthLargest {

        private PriorityQueue<Integer> queue;

        private int size;

        public KthLargest(int k, int[] nums) {
            this.size = k;
            this.queue = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
            }
        }

        public int add(int val) {
            queue.offer(val);
            while (queue.size() > size) {
                queue.poll();
            }
            return queue.peek();
        }
    }


}
