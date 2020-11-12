package myanswer.sort.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @FileName: No973.java
 * @Description: 最接近原点的K个点
 * @Author: admin
 * @Date: 2020/11/9 9:43
 */
public class No973 {

    public int[][] kClosest(int[][] points, int K) {
        // 优先队列，默认最小堆，我们用最小堆就好了
        PriorityQueue<int[]> heap = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 注意这里要加括号
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        heap.addAll(Arrays.asList(points));
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        No973 no973 = new No973();
        int[][] points = {
                {2, 2},
                {3, 3},
                {4, 4},
                {1, 1},
                {5, 5}
        };
        int[][] ans = no973.kClosest(points, 3);
        for (int[] an : ans) {
            System.out.println(an[0] + " " + an[1]);
        }
    }


}
