package weeklytest;

import java.util.SortedMap;
import java.util.TreeMap;

public class No5748 {

    public int[] minInterval(int[][] intervals, int[] queries) {
        // 需要使用离线算法
        return null;
    }


    public static void main(String[] args) {
        int[][] intervals = {
                {1, 4},
                {2, 4},
                {3, 6},
                {4, 4}
        };
        int[] queries = {2, 3, 4, 5};
        No5748 no5748 = new No5748();
        int[] ans = no5748.minInterval(intervals, queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


}
