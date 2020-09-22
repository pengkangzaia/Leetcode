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
        if (path.size() == nums.length) {

        }
        for (Integer num : nums) {
            path.add(num);
            traverse(nums, path);
            path.removeLast();
        }

    }


}
