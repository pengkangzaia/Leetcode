package myanswer.dfsandbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No207.java
 * @Description: 课程表
 * @Author: admin
 * @Date: 2020/10/27 17:11
 */
public class No207 {
    // 你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
    // 在选修某些课程之前需要一些先修课程,例如，想要学习课程 0 ，你需要先完成课程 1 ，
    // 我们用一个匹配来表示他们：[0,1]
    // 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

/*public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断有没有一条链路，长度为numCourses，无环:是否是有向无环图
        // 拓扑排序：对 DAG 的顶点进行排序，使得对每一条有向边(u,v)，
        // 均有 u（在排序记录中）比 v 先出现。亦可理解为对某点 v 而言，
        // 只有当 v 的所有源点均出现了，v 才能出现。
        // 通过prerequisites可以得到邻接表
        return false;
    }*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        // 入度表
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            // 从cp[1]到cp[0]，邻接
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            // 入度为0的节点
            int pre = queue.poll();
            numCourses--;
            // 当前入度为0的节点的后续节点
            for(int cur : adjacency.get(pre))
                // 后续节点的入度要减1，如果后续节点的入度为0了，就把他加到队列中。
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    public boolean myCanFinish(int numCourses, int[][] prerequisites) {
        // BFS拓扑排序解法：需要三种数据结构
        // 入度表，邻接表，存放入度为0的队列
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 构建入度表，邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            // 不能这样写prerequisites[i].length一直会等于2
            // indegree[prerequisites[i][0]] = prerequisites[i].length;
            indegree[prerequisites[i][0]]++;
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 队列填充入度为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // BFS遍历节点
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            numCourses--;
            // 遍历当前节点的下一节点，使其入度减1
            // 如果入度为0，则加到队列中
            for (Integer next : adjacency.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return numCourses == 0;
    }


    // DFS解法：判断是否有环
    public boolean myDFSCanFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // flag标记节点是否被访问过
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // dfs判断是否有环，无环为true。如果都无环，返回false
            if(!dfs(flag, adjacency, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] flag, List<List<Integer>> adjacency, int i) {
        // 递归结束条件
        if (flag[i] == 1) {
            // 表示当前节点被第二次搜索
            return false;
        } else if (flag[i] == -1) {
            // 当前节点已经被其他节点dfs访问
            return true;
        }
        flag[i] = 1; // 表示已被遍历
        for (Integer next : adjacency.get(i)) {
            if (!dfs(flag, adjacency, next)) {
                return false;
            }
        }
        flag[i] = -1; // 表示当前节点已被判断无环
        return true;
    }


}
