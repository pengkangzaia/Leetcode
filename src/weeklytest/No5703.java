package weeklytest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @FileName: No5703.java
 * @Description: 最大平均通过率
 * @Author: camille
 * @Date: 2021/3/14 11:31
 */
public class No5703 {


    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 优先队列求解
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double a = (o1[1] - o1[0]) * 1.0 / (o1[1] * o1[1] - o1[1]);
                double b = (o2[1] - o2[0]) * 1.0 / (o2[1] * o2[1] - o2[1]);
                if (a == b) {
                    return 0;
                }
                return a - b > 0 ? -1 : 1;
            }
        });

        for (int[] aClass : classes) {
            queue.offer(aClass);
        }

        while (extraStudents > 0) {
            int[] currClass = queue.poll();
            currClass[0]++;
            currClass[1]++;
            queue.offer(currClass);
            extraStudents--;
        }

        double sum = 0;
        while (!queue.isEmpty()) {
            int[] currClass = queue.poll();
            int x = currClass[0];
            int y = currClass[1];
            sum += x * 1.0 / y;
        }

        return sum / classes.length;
    }

    public static void main(String[] args) {
        int[][] classes = {
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        };
        No5703 no5703 = new No5703();
        double ans = no5703.maxAverageRatio(classes, 4);
        System.out.println(ans);
    }


}
