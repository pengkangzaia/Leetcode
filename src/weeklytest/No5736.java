package weeklytest;

import java.util.*;

public class No5736 {

    // 单线程CPU
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // 任务队列用堆，每次拉出处理时间最短的
        // 入队直接排序+记录索引
        HashMap<int[], Integer> taskIdxMap = new HashMap<>(n);
        PriorityQueue<int[]> taskList = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return taskIdxMap.get(o1) - taskIdxMap.get(o2);
            }
        });
        for (int i = 0; i < tasks.length; i++) {
            taskIdxMap.put(tasks[i], i);
        }
        Arrays.sort(tasks, (o1, o2) -> o1[0] - o2[0]);

        int currTime = 0;
        int currIdx = 0;

        ArrayList<Integer> res = new ArrayList<>();
        while (currIdx < n) {
            // 先判断入队，再取任务
            if (currTime >= tasks[currIdx][0]) {
                taskList.offer(tasks[currIdx]);
                currIdx++;
            } else {
                if (taskList.size() == 0) {
                    // cpu没有任务一直空转到下一个任务开始时间
                    currTime = tasks[currIdx][0];
                } else {
                    int[] currTask = taskList.poll();
                    currTime = currTime + currTask[1];
                    res.add(taskIdxMap.get(currTask));
                }
            }
        }

        while (!taskList.isEmpty()) {
            int[] currTask = taskList.poll();
            currTime = currTime + currTask[1];
            res.add(taskIdxMap.get(currTask));
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] tasks = {
                {19,13},
                {16,9},
                {21,10},
                {32,25},
                {37,4},
                {49,24},
                {2,15}
        };
        No5736 no5736 = new No5736();
        int[] order = no5736.getOrder(tasks);
        for (int i = 0; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }


    /**
     * 输入：
     * [[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
     * 输出：
     * [0,2,5,7,8,11,4,3,1,13,6,9,12,10]
     * 预期：
     * [6,1,2,9,4,10,0,11,5,13,3,8,12,7]
     */

    /**
     * 输入：
     * [[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
     * 输出：
     * [6,1,2,9,4,10,0,11,13,5,3,8,12,7]
     * 预期：
     * [6,1,2,9,4,10,0,11,5,13,3,8,12,7]
     */

}
