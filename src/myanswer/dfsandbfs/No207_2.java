package myanswer.dfsandbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No207_2.java
 * @Description: 课程表2刷
 * @Author: admin
 * @Date: 2020/11/18 10:17
 */
public class No207_2 {

    // 拓扑排序+BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 维护三个数据结构
        Queue<Integer> queue = new LinkedList<>(); // 入度为0的队列
        int[] inDegree = new int[numCourses]; // 入度表
        List<List<Integer>> next = new LinkedList<>(); // 邻接矩阵，一个节点的下一个节点可以是那些
        for (int i = 0; i < numCourses; i++) {
            next.add(new ArrayList<>());
        }

        // 根据数据，初始化入度表和邻接矩阵
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            next.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 将入度为0的点添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 移除这个入度为0的节点
            Integer course = queue.poll();
            numCourses--;
            // 遍历该节点的下一个节点
            for (Integer nextCourse : next.get(course)) {
                // 移除了当前节点，下一个节点的入度减一
                inDegree[nextCourse]--;
                // 更新入度为0的队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return numCourses == 0;

    }

}
