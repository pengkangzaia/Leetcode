package myanswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No60.java
 * @Description: 第k个排列
 * @Author: 彭康
 * @Date: 2020/9/24 10:07
 */
public class No60 {

    public List<String> res = new LinkedList<>();

    public String getPermutation(int n, int k) {
        StringBuilder path = new StringBuilder();
        int[] nums = new int[n];
        boolean[] visit = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        traverse(nums, path, n, k, visit);
        return res.get(res.size() - 1);
    }

    private void traverse(int[] nums, StringBuilder path, int n, int k, boolean[] visit) {

        if (res.size() == k) {
            return;
        }
        if (path.length() == n) {
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            path.append(nums[i]);
            visit[i] = true;
            traverse(nums, path, n, k, visit);
            visit[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        No60 no60 = new No60();
        String ans = no60.getPermutation(4, 15);
        System.out.println(ans);
    }


}
