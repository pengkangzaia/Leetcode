package daily;

import java.util.*;

/**
 * @FileName: No621.java
 * @Description: 任务调度器
 * @Author: camille
 * @Date: 2020/12/5 12:47
 */
public class No621 {

    // 贪心解法，这里模拟错了，每放置 n 个数就要将优先队列更新。
    // 是一个位置一个位置的放，而不是一个字母一个字母的放
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        char[] process = new char[tasks.length * n]; // 最后这么长
        Arrays.fill(process, '#'); // # 表示未被赋值
        int emptyIndex = 0; // process数组未被赋值的第一个元素
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 如果是 o1 - o2 的话，取出来就是从小到大取
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char task = entry.getKey();
            int count = entry.getValue();
            int currIndex = emptyIndex;
            while (currIndex < process.length && count > 0) {
                process[currIndex] = task;
                count--;
                currIndex += n + 1; // 两个相同任务之间要有 n 个不同任务。
            }
            // 更新 emptyIndex
            while (emptyIndex < process.length && Character.isLetter(process[emptyIndex])) {
                emptyIndex++;
            }
        }
        for (int i = process.length - 1; i >= 0; i--) {
            if (Character.isLetter(process[i])) {
                return i + 1; // 返回的不是索引，是队列的长度
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        No621 no621 = new No621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        int ans = no621.leastInterval(tasks, 2);
        System.out.println(ans);
    }

}
