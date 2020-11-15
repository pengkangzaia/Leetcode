package myanswer.linkedlist.medium;

import myanswer.string.No13;

import java.util.HashMap;

/**
 * @FileName: No138.java
 * @Description: 复制带随机指针的链表
 * @Author: admin
 * @Date: 2020/11/14 19:28
 */
public class No138 {

    public Node copyRandomList(Node head) {
        // 克隆节点，并做源节点和克隆节点的映射
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            map.put(curr, node);
            curr = curr.next;
        }
        for (Node node : map.keySet()) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);

        // 方法2，直接在原链表上复制 todo
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        No138 no138 = new No138();
        Node ans = no138.copyRandomList(node1);
        System.out.println(ans);
    }

}
