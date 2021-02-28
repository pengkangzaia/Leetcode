package myanswer.dfsandbfs;

import java.util.List;

/**
 * @FileName: No841.java
 * @Description: 钥匙和房间
 * @Author: camille
 * @Date: 2021/2/27 19:46
 */
public class No841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //43
        int n = rooms.size();
        // DFS深度优先搜索
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int idx) {
        if (!visited[idx]) {
            // 如果房间没有被访问过
            visited[idx] = true;
            List<Integer> keys = rooms.get(idx);
            for (int i = 0; i < keys.size(); i++) {
                dfs(rooms, visited, keys.get(i));
            }
        }
    }




}
