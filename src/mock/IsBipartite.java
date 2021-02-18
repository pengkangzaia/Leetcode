package mock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @FileName: IsBipartite.java
 * @Description: IsBipartite.java类说明
 * @Author: admin
 * @Date: 2021/2/18 16:24
 */
public class IsBipartite {

    public static boolean isBipartite(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w: graph[v]) {
                    // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        queue.offer(w);
                    }
                }
            }
        }

        return true;
    }

    /*作者：sweetiee
    链接：https://leetcode-cn.com/problems/is-graph-bipartite/solution/bfs-dfs-bing-cha-ji-san-chong-fang-fa-pan-duan-er-/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        boolean ans = isBipartite(new int[][]{
                {1, 4},
                {0, 2},
                {1},
                {4},
                {0, 3}
        });
        System.out.println(ans);
    }

    public boolean isBipartite1(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                // 没有被访问过
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int j = 0; j < graph[v].length; j++) {
                        int w = graph[v][j];
                        if (visited[w] == visited[v]) {
                            return false;
                        }
                        if (visited[w] == 0) {
                            visited[w] = -1 * visited[v];
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return true;
    }


}
