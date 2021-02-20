package myanswer.array.easy;

import java.util.HashMap;

/**
 * @FileName: No697.java
 * @Description: No697.java类说明
 * @Author: camille
 * @Date: 2021/2/20 11:48
 */
public class No697 {

    public int findShortestSubArray(int[] nums) {
        // 出现频数的最大值
        // 维护一个对象：频数，开始位置，结束位置
        int maxCount = 0;
        HashMap<Integer, Number> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Number nb = map.getOrDefault(nums[i], new Number(nums[i], 0, i, i));
            nb.count++;
            nb.end = i;
            map.put(nums[i], nb);
            maxCount = Math.max(maxCount, nb.count);
        }

        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            Number nb = map.get(key);
            if (nb.count == maxCount) {
                res = Math.min(res, nb.end - nb.start + 1);
            }
        }

        return res;

    }

    class Number {
        int num;
        int count;
        int start;
        int end;
        public Number(int n, int c, int s, int e) {
            num = n;
            count = c;
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        No697 no697 = new No697();
        int ans = no697.findShortestSubArray(nums);
        System.out.println(ans);
    }


}
