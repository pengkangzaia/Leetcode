package myanswer.sort.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No57.java
 * @Description: 插入区间
 * @Author: admin
 * @Date: 2021/2/2 17:02
 */
public class No57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        int[][] combineIntervals = new int[intervals.length + 1][2];
        int idx = 0;
        boolean isUsed = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!isUsed && newInterval[0] <= intervals[i][0]) {
                combineIntervals[idx++] = newInterval;
                combineIntervals[idx++] = intervals[i];
                isUsed = true;
            } else {
                combineIntervals[idx++] = intervals[i];
                if (!isUsed && i == intervals.length - 1) {
                    combineIntervals[idx] = newInterval;
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < combineIntervals.length; i++) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] < combineIntervals[i][0]) {
                res.add(combineIntervals[i]);
            } else {
                int[] temp = res.get(res.size() - 1);
                temp[1] = Math.max(temp[1], combineIntervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        No57 no57 = new No57();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        int[][] ans = no57.insert(intervals, newIntervals);
        System.out.println();
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        // 遍历区间列表：
        // 首先将新区间左边且相离的区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        // 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);
    }


}
