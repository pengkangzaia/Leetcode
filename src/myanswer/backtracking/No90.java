/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No90.java
 * @Description: 子集2（数组中包含重复元素）
 * @Author: kang.peng
 * @Date: 2020/9/22 23:02
 */
public class No90 {

    // 对数组先进行排序，然后设置visit数组用于限定（1.访问过的不再访问  2.重复元素的按顺序访问）

    public List<List<Integer>> res = new LinkedList<>();
    public boolean[] visit;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        traverse(nums, new LinkedList<>(), 0);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path, int index) {
        // 不要直接加path啊
        res.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            // 和全排列2一样
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            visit[i] = true;
            traverse(nums, path, i + 1);
            visit[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        No90 no90 = new No90();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = no90.subsetsWithDup(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
