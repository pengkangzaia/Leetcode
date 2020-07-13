package MyAnswer.array.medium;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0 || nums == null) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, used, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, boolean[] used, int depth,
                     List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, used, depth + 1, path, res);
                used[i] = false;
                path.remove(path.size() - 1); // 移除最后一个元素
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        No46 no46 = new No46();
        List<List<Integer>> ans = no46.permute(nums);
        for(List<Integer> list : ans) {
            for(int num : list) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

}
