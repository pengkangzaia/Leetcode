/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.backtracking;

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
    // 结束：这题没有结束条件

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(nums, path, 0);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path, int index) {
        // 不能直接加path啊
        res.add(new LinkedList<>(path));
        // 这题没有结束条件？其实是有的，不过隐含在循环中了。
        if (index > nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            // 注意这里时 i+1，不是 index+1，index在这里是不变的
            traverse(nums, path, i + 1);
            path.remove(path.size() - 1);
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
