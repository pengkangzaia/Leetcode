package mock;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: SubsetsWithDup.java
 * @Description: SubsetsWithDup.java类说明
 * @Author: admin
 * @Date: 2021/2/11 17:13
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, path, res, visited, 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] visited, int idx) {
        res.add(new LinkedList<>(path));
        for (int i = idx; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, path, res, visited, idx+1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup solution = new SubsetsWithDup();
        List<List<Integer>> ans = solution.subsetsWithDup(new int[]{1, 2, 3});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

}
