package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No452.java
 * @Description: 用最少数量的箭引爆气球
 * @Author: camille
 * @Date: 2021/2/20 20:50
 */
public class No452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        int count = 1;
        // 最近新增了Test Case， [[-2147483646,-2147483645],[2147483646,2147483647]] 就过不了了，
        // 这是因为差值过大而产生溢出。sort的时候不要用a-b来比较，要用Integer.compare(a, b)!!!
        // (o1[0] < o2[0]) ? -1 : ((o1[0] == o2[0]) ? 0 : 1) 这个使Integer.compare的源码
        Arrays.sort(points, (o1, o2) -> (Integer.compare(o1[1], o2[1])));
        int max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > max) {
                // 当前的🗡射不爆下一个气球
                count++;
                max = points[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        No452 no452 = new No452();
        int[][] nums = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };
        int ans = no452.findMinArrowShots(nums);
        System.out.println(ans);
    }


}
