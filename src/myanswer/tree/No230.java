package myanswer.tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @FileName: No230.java
 * @Description: 二叉搜索树中第k小元素
 * @Author: admin
 * @Date: 2020/10/22 17:00
 */
public class No230 {

    private PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public int kthSmallest(TreeNode root, int k) {
        // 最直观的方法，把root转化为最小堆，
        // 堆的大小保持为k，堆顶元素就是第k小元素
        dfs(root, k);
        return heap.peek();
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        heap.add(root.val);
        if (heap.size() > k) {
            heap.poll();
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        No230 no230 = new No230();
        int ans = no230.kthSmallest2(n1, 3);
        System.out.println(ans);
        ans = no230.kthSmallest3(n1, 3);
        System.out.println(ans);
    }

    // 解法二，用栈来查找
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
               stack.push(root);
               root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

    // 解法3，用中序遍历+计数的方法
    private int res = 0;
    private int num = 0;
    public int kthSmallest3(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) { return; }
        traverse(root.left, k);
        num++;
        if (num == k) { res = root.val; }
        traverse(root.right, k);
    }


}
