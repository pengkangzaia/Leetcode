/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No39.java
 * @Description: 选择数组中的数组成一个集合，满足集合等于 target
 * @Author: admin
 * @Date: 2020/9/23 9:33
 */
public class No39 {

    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        traverse(candidates, path, 0, target, 0);
        return res;
    }

    public void traverse(int[] candidates, LinkedList<Integer> path, int sum, int target, int index) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        } else {
            // 解集不能包含重复的组合。
            // 之前遍历过的现在不用再遍历了
            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);
                sum += candidates[i];
                // 但是可能有重复值，所以这里要包含当前元素
                traverse(candidates, path, sum, target, i);
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        No39 no39 = new No39();
        int[] candidates = {2,3,5};
        List<List<Integer>> res = no39.combinationSum(candidates, 8);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
