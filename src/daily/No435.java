package daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @FileName: No435.java
 * @Description: 无重叠区间
 * @Author: admin
 * @Date: 2020/12/31 9:19
 */
public class No435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 15开始
        // 两种情况，前面的终点比后面的终点大，取后面的
        // 前面的终点比后面的终点小，取前面的
        // 其实就是优先拿终点小的
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int n = intervals.length;
        // 怎么移除元素？
        // 移除元素很麻烦的话，就转化为不要移除元素的解法，直接统计个数
        int res = 0;
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return n - res;
    }


}
