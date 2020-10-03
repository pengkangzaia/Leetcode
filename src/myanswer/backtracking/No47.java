/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.*;

/**
 * @FileName: No47.java
 * @Description: No47.java类说明
 * @Author: admin
 * @Date: 2020/9/22 9:34
 */
public class No47 {

    public List<List<Integer>> res = new LinkedList<>();
    public boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        traverse(nums, path);
        return res;
    }

    /**
     *
     * @param nums 待排列数组
     * @param path 已选择路径
     */
    public void traverse(int[] nums, LinkedList<Integer> path) {
        // 结束条件
        int n = path.size();
        if (n == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        // 遍历
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i>0 && nums[i]==nums[i-1] && !visit[i-1])) {
                continue;
            }
            path.add(nums[i]);
            visit[i] = true;
            traverse(nums, path);
            visit[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        No47 no47 = new No47();
        int[] nums = {1,2,1};
        List<List<Integer>> res = no47.permuteUnique(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
