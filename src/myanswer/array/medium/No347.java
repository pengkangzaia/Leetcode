package myanswer.array.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class No347 {

    // 前 k 个高频元素
    // 首先想到的是最大堆，Java的优先队列是使用最小堆实现的
    // 要实现最大堆，需要自定义比较器
    // 2020/7/13 21:16 第一次AC，效率不高，尝试优化
    public int[] topKFrequent(int[] nums, int k) {
        // 一个 hashmap，一个 优先队列
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            queue.add(key);
        }
        int count = 0;
        while (count < k) {
            res[count] = queue.poll();
            count++;
        }

        return res;

    }

    // // 2020/7/13 21:24 第二次AC，尝试最小堆，当队列大小达到k时弹出最小值。
    public int[] topKFrequentFast(int[] nums, int k) {
        // 一个 hashmap，一个 最小堆优先队列
        /*int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll(); // 把最小值拉出来
            }
        }
        int count = 0;
        while (queue.size() > 0) {
            res[count++] = queue.poll();
        }

        return res;*/

        // 哈希表，key为数组元素，value为元素出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 0);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;

    }

    public static void main(String[] args) {
        No347 no347 = new No347();
        int[] nums = {1,2,2,3,3,3,1,1};
        int[] ans = no347.topKFrequentFast(nums, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
