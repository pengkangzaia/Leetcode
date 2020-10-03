/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.tree;

import java.util.Arrays;

/**
 * @FileName: No108.java
 * @Description: No108.java类说明
 * @Author: kang.peng
 * @Date: 2020/9/20 21:52
 */
public class No108 {

    /**
     * 取当前数组中间值为根节点
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = findRoot(nums);
        return res;
    }

    public TreeNode findRoot(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            TreeNode root = new TreeNode(nums[0]);
            return root;
        } else {
            TreeNode root = new TreeNode(nums[n / 2]);
            root.left = findRoot(Arrays.copyOfRange(nums, 0, n / 2));
            root.right = findRoot(Arrays.copyOfRange(nums, (n / 2) + 1, n));
            return root;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] nums = {-10,-3,0,5,9};
        No108 no108 = new No108();
        TreeNode root = no108.findRoot(nums);
        Thread.sleep(1000);
    }

}
