/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package MyAnswer.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No78.java
 * @Description: 子集
 * @Author: admin
 * @Date: 2020/9/22 20:12
 */
public class No78 {

    // 路径：所有遍历过的集合
    // 待选：没有完全遍历完的元素集合
    // 结束：到达数组大小

    List<List<Integer>> res = new LinkedList<>();
    boolean[] visit;

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        visit = new boolean[nums.length];
        traverse(nums, path);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path) {
        // 不能直接加path啊
        res.add(new LinkedList<>(path));
        if (path.size() == nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            path.add(nums[i]);
            visit[i] = true;
            traverse(nums, path);
//            visit[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        No78 no78 = new No78();
        int[] nums = {1,2,3};
        List<List<Integer>> res = no78.subsets(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
