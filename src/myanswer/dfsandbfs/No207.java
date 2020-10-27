package myanswer.dfsandbfs;

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断有没有一条链路，长度为numCourses，无环:是否是有向无环图
        return false;
    }

}
