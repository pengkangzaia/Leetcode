package myanswer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No95.java
 * @Description: 不同的二叉搜索树 II
 * @Author: admin
 * @Date: 2021/2/9 22:44
 */
public class No95 {

    // 回溯求解
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getListTree(1, n);
    }

    private List<TreeNode> getListTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null); // 集合里有值，可以进下面的循环。但是是一个空指针
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = getListTree(start, i - 1);
            List<TreeNode> rightList = getListTree(i + 1, end);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = leftList.get(j);
                    curr.right = rightList.get(k);
                    res.add(curr);
                }
            }
        }
        return res;
    }


}
