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

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        No297 no297 = new No297();
        String serialize = no297.serialize(n1);
        System.out.println(serialize);
        TreeNode deserialize = no297.deserialize(serialize);
        System.out.println(deserialize);
    }


}
