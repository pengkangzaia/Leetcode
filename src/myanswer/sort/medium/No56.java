package myanswer.sort.medium;

import java.util.*;

public class No56 {
    public static void main(String[] args) {
        int[][] a = {{1,4},{2,3}};
        int[][] b ={};
        System.out.println(Arrays.deepToString(a));

        int[][] ans = merge(a);
        System.out.println(Arrays.deepToString(ans));
    }

    private static int[][] merge(int[][] a) {

        if(a!=null&&a.length>0){
            Arrays.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] nums1, int[] nums2) {
                    if(nums1[0]==nums2[0])
                        return nums1[1]-nums2[1];
                    return nums1[0]-nums2[0];
                }
            });

            int[][] temp = new int[a.length][a[0].length];
            int j = 0;
            temp[j] = a[j];
            for (int i = 1; i < a.length; i++) {
                if(temp[j][1]>=a[i][0]&&temp[j][1]<a[i][1]){
                    //合并
                    temp[j][1] = a[i][1];
                } else if (temp[j][1]>=a[i][0]&&temp[j][1]>=a[i][1]){
                    continue;
                }
                else {
                    //赋值给temp
                    j++;
                    temp[j] = a[i];
                }

            }
            //0,1,2 j=2,行数为3
            int[][] temp1 = new int[j+1][temp[0].length];
            for (int i = 0; i < j+1; i++) {
                temp1[i] = temp[i];
            }
            return temp1;
        }
        return a;
    }


    public int[][] merge1(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }


    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                int[] temp = res.get(res.size() - 1);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                res.remove(res.size() - 1);
                res.add(temp);
            }
        }
        // 底层原理是将res中的元素拷贝到这个新new出来的数组里面
        return res.toArray(new int[res.size()][]);
    }

}
