package myanswer.tree;

import java.util.HashMap;

/**
 * @FileName: No437_2.java
 * @Description: 路径之和3，自己实现前缀和解法版本
 * @Author: camille
 * @Date: 2020/11/21 20:52
 */
public class No437_2 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 前缀和，key为当前节点之前各个节点的前缀和，value为该前缀和值出现的次数
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return findSum(root, 0, sum, prefixSum);
    }

    private int findSum(TreeNode root, int prevSum, int sum, HashMap<Integer, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }
        int currSum = prevSum + root.val;
        int res = 0;
        // 先比对之前节点的前缀和信息，然后再把自己的信息加进行，防止多算了
        res += prefixSum.getOrDefault(currSum - sum, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        // 回溯开始
        res += findSum(root.left, currSum, sum, prefixSum);
        res += findSum(root.right, currSum, sum, prefixSum);
        // 回溯结束，返回原来的状态
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return res;
    }


}
