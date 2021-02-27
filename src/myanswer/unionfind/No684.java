package myanswer.unionfind;

import java.util.Arrays;

/**
 * @FileName: No684.java
 * @Description: 冗余连接
 * @Author: camille
 * @Date: 2021/2/27 15:33
 */
public class No684 {

    public int[] findRedundantConnection(int[][] edges) {
        // 怎么检测出环呢？
        // 并查集
        // 二维数组中的整数在1到N之间，其中N是输入数组的大小。
        int N = edges.length;
        int[] root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i + 1;
        }
        for (int i = 0; i < edges.length; i++) {
            if (find(root, edges[i][0]) == find(root, edges[i][1])) {
                return edges[i];
            } else {
                union(root, edges[i][0], edges[i][1]);
            }
        }
        return new int[2];
    }

    // 寻找该点的根节点
    private int find(int[] root, int num) {
        if (root[num - 1] != num) {
            return find(root, root[num - 1]);
        } else {
            return num;
        }
    }

    private void union(int[] root, int x, int y) {
        int gen = find(root, x);
        // root[y - 1] = gen; // 不能只改变y所属的连通分量，要把属于x的连通分量和y的连通分量连接到一起
        root[find(root, y) - 1] = gen;
    }

    public static void main(String[] args) {
        No684 no684 = new No684();
        int[][] edges = {
                {3,4},
                {1,2},
                {2,4},
                {3,5},
                {2,5}
        };
        int[] ans = no684.findRedundantConnection(edges);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}
