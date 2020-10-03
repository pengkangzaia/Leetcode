/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No77.java
 * @Description: 组合
 * @Author: kang.peng
 * @Date: 2020/9/23 8:44
 */
public class No77 {

    public List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        LinkedList<Integer> path = new LinkedList<>();
        traverse(nums, path, k, 0);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path, int k, int index) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            traverse(nums, path, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        No77 no77 = new No77();
        List<List<Integer>> combine = no77.combine(4, 2);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
