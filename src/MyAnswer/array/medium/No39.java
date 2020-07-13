package MyAnswer.array.medium;

import java.util.LinkedList;
import java.util.List;

public class No39 {

/*    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        int[] used = new int[len];
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates,len,0,path,0,target,used,res);
        return res;
    }

    private void dfs(int[] candidates, int len, int depth, LinkedList<Integer> path, int pathSum,
                     int target, int[] used, List<List<Integer>> res) {
        if (pathSum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (pathSum > target) {
            return;
        }
        if (depth == len) {
            return;
        }
        for (int i = 0; i < used.length; i++) {
            used[i]++;
            pathSum += candidates[i];
            depth++;
            path.add(candidates[i]);
            dfs(candidates, len, depth+1, path, pathSum, target, used, res);
            path.removeLast();
            depth--;
            pathSum -= candidates[i];
            used[i]--;
        }
    }*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(0, candidates, target, path, res);
        return res;
    }

    // begin 用于剪枝去重
    private void dfs(int begin, int[] candidates, int target, List<Integer> path, List<List<Integer>> res) {
        if (target >= 0) {
            if (target == 0) {
                res.add(new LinkedList<>(path));
            } else {
                for (int i = begin; i < candidates.length; i++) {
                    path.add(candidates[i]);
                    dfs(i, candidates, target - candidates[i], path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        No39 no39 = new No39();
        List<List<Integer>> ans = no39.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : ans) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
