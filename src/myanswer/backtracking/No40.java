package myanswer.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No40.java
 * @Description: 组合总和2
 * @Author: admin
 * @Date: 2020/9/23 12:56
 */
public class No40 {

    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        traverse(candidates, path, target, 0, 0);
        return res;
    }

    public void traverse(int[] candidates, LinkedList<Integer> path, int target, int sum, int index) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            // 不能直接加 path
            res.add(new LinkedList<>(path));
            return;
        } else {
            // 每个元素只能用一次
            for (int i = index; i < candidates.length; i++) {
                // 1，1，2，6
                // 【1，2，6】（1的位置为0）
                // 【1，2，6】（1的位置为1）
                // 这样会导致重复，所以只要第一次回溯过了，后面相同的元素就不需要回溯了（会产生重复代码）
                // 选择第一次出现的元素进行回溯，还可以让后面的相同元素有机会被添加到path里
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                sum += candidates[i];
                // 从下一个元素开始，第i个元素已经用过了
                traverse(candidates, path, target, sum, i + 1);
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        No40 no40 = new No40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = no40.combinationSum21(candidates, 8);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        // 怎么去除重复元素呢？
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(candidates, res, path, target, 0);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> path, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                // 如果出现重复的元素，则只取第一次出现的数。
                if (i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates, res, path, target - candidates[i], i + 1); // 这里是从i开始的，而不是从index开始的。要的是当前遍历的数字之后的数字
                path.remove(path.size() - 1);
            }
        }
    }
}
