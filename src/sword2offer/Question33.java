package sword2offer;

import java.util.Arrays;

public class Question33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }

        // 从前到后查找第一个大于根节点（数组最后一个元素）的值
        int k = i;
        while (postorder[k] < postorder[j]) {
            k++;
        }
        int m = k; // 保留这个索引
        while (postorder[k] > postorder[j]) {
            k++;
        }
        // 如果 k != j 则右子树中有元素小于root，不符合二叉搜索树的定义
        // recur(postorder, m, j-1) 注意这里是 j-1 不是 j
        return k == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    public boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return recur1(postorder, 0, postorder.length - 1);
    }

    boolean recur1(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int k = i;
        while (postorder[k] < postorder[j]) k++;
        int m = k;
        while (postorder[k] > postorder[j]) k++;
        return k == j && recur1(postorder, i, m - 1) && recur1(postorder, m, j - 1);
    }

}
