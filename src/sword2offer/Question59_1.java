package sword2offer;

import java.util.Collections;
import java.util.LinkedList;

public class Question59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int index = 0;
        // res 存放滑动窗口最大值
        int[] res = new int[n - k + 1];
        // linkedlist作为双端队列，存数组索引，头节点为滑窗最大值
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 移除尾元素
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            // 添加尾元素
            queue.addLast(i);
            // 添加头元素
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            // 这里不能是 i>k 比如说k=2，i>k时i要是3才可以，但其实不是。i=1就可以了
            if (i>=(k-1)) {
                res[index++] = nums[queue.peekFirst()];
            }

        }
        return res;

    }

    public static void main(String[] args) {
        Question59_1 question59_1 = new Question59_1();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = question59_1.maxSlidingWindow(nums, 3);
        for (int an : ans) {
            System.out.println(an);
        }
    }

}
