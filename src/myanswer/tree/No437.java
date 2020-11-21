package myanswer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No437.java
 * @Description: 路径之和
 * @Author: camille
 * @Date: 2020/11/21 19:56
 */
public class No437 {

    private int res = 0;

    // 暴力解法，遍历树中每一个节点。
    // 找到以当前节点为起点的路径使得路径之和为sum。
    // 还有一种前缀和算法，学习一下。
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        findSum(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void findSum(TreeNode root, int prevSum, int sum) {
        if (root == null) {
            return;
        }
        if (root.val + prevSum == sum) {
            res++;
        }
        findSum(root.left, prevSum + root.val, sum);
        findSum(root.right, prevSum + root.val, sum);
    }


    // 解法2，前缀和求解
    // key：从根节点到某一节点的路径和 value：路径和为key的路径数目
    private Map<Integer,Integer> prefixSumCount;
    private int target;
    public int pathSum1(TreeNode root, int sum) {
        prefixSumCount = new HashMap<>();
        // curPathSum-target为0说明当前路径和就是target，找的了一条符合要求的路径
        prefixSumCount.put(0,1);
        this.target = sum;
        return dfs(root,0);
    }
    private int dfs(TreeNode root,int preSum){
        if(root == null){
            return 0;
        }
        int curPathSum = preSum + root.val;
        int curRes = 0;
        // 如果在前缀路径和中发现有值为curPathSum-target的（可能会>1，即多条前缀路径）
        // 那么路径和为curPathSum的路径的最后一个节点的下一个节点到当前节点的和等于target（画个图就知道了）
        //          root->  o 10               prefixSumCount有 10:1 15:1
        //                  |                     curPathSum  为  18
        //                  o 5              curPathSum-target 为 18-8 = 10
        //                 /              因此路径和为10的路径的最后一个节点（10）的下一个节
        //       cur->    o 3             点（5）到cur（3）为一条满足和为target（8）的路径
        curRes += prefixSumCount.getOrDefault(curPathSum-target,0);
        // 进入左右子树前，先把 本路径的和 的计数器更新（+1）（这个路径会是左右子树的前缀）
        prefixSumCount.put(curPathSum,prefixSumCount.getOrDefault(curPathSum,0)+1);
        curRes += dfs(root.left,curPathSum);
        curRes += dfs(root.right,curPathSum);
        // 左右子树遍历完后，把 本路径的和 的计数器更新（-1）（因为这个路径不可能是别的路径的前缀了）,
        // 这一行最重要，也最难理解。其实是回溯的思想，上一层的节点不能用到下一层的前缀和信息
        prefixSumCount.replace(curPathSum,prefixSumCount.get(curPathSum)-1);
        return curRes;
    }

}
