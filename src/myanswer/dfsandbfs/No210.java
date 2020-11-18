package myanswer.dfsandbfs;

import java.util.*;

/**
 * @FileName: No210.java
 * @Description: 课程表2
 * @Author: admin
 * @Date: 2020/11/18 10:36
 */
public class No210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 维护三个数据结构
        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>(); // 入度为0的队列
        int[] inDegree = new int[numCourses];
        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            next.add(new ArrayList<>());
        }

        // 初始化入度表和邻接矩阵
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            next.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 将入度为0的节点加入到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            numCourses--;
            res.add(course);
            for (Integer nextCourse : next.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        if (numCourses == 0) {
            int[] ans = new int[res.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = res.get(i);
            }
            return ans;
        } else {
            return new int[0];
        }

    }

    public static void main(String[] args) {

    }

}
