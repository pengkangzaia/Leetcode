package myanswer.linkedlist.medium;

/**
 * @FileName: Node.java
 * @Description: Node.java类说明
 * @Author: admin
 * @Date: 2020/11/14 19:29
 */
public class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
