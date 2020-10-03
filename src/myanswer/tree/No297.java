package myanswer.tree;

import java.util.LinkedList;
import java.util.Queue;

public class No297 {

    // 二叉树的序列化和反序列化
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序遍历序列化二叉树
        if (root == null) {
            return "null,";
        }
        String str = String.valueOf(root.val) + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        return inverseSerialize(queue);
    }

    private TreeNode inverseSerialize(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = inverseSerialize(queue);
        node.right = inverseSerialize(queue);
        return node;
    }


}
