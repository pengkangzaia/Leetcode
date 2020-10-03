package myanswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No216.java
 * @Description: 组合总和3
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * @Author: admin
 * @Date: 2020/9/23 15:49
 */
public class No216 {

    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;
        int index = 0;
        traverse(nums, path, sum, n, index, k);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path, int sum, int n, int index, int k) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                return;
            } else {
                return;
            }
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            traverse(nums, path, sum, n, i+1, k);
            sum -= nums[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        No216 no216 = new No216();
        List<List<Integer>> lists = no216.combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
