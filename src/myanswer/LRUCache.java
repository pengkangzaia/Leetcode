package myanswer;

import java.util.HashMap;

/**
 * @FileName: LRUCache.java
 * @Description: No146.java类说明
 * @Author: admin
 * @Date: 2021/2/15 21:59
 */
public class LRUCache {

    // 节点的数据结构
    public static class Node {
        int key;
        int value;
        Node next;
        Node last;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 自定义双向链表
    public class NodeDoubleLinkedList {
        Node head;
        Node tail;


        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // 三个方法：
        // 在双向链表中向尾节点添加节点
        public void addLastNode(Node node) {
            if (node == null) {
                return;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            }
        }

        // 把一个节点从链表中删除，添加到链表尾部
        public void deleteNodeAddToLast(Node node) {
            if (node == null || node == this.tail) {
                // 需要先判断 node 是否等于 this.tail节点，否则下面会报空指针异常
                return;
            }

            if (node == this.head) {
                Node newHead = this.head.next;
                this.head = newHead;
                newHead.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            this.tail.next = node;
            node.last = this.tail;
            node.next = null;
            this.tail = node;
        }

        // 移除链表头部节点并返回该节点
        public Node removeHead() {
            if (this.head == null) {
                return null;
            }
            Node toBeRemoveNode = this.head;
            // 需要考虑链表只有一个节点的情况,否则this.head.last会报错
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = toBeRemoveNode.next;
                this.head.last = null;
                // toBeRemoveNode的next节点需要清空
                toBeRemoveNode.next = null;
            }
            return toBeRemoveNode;
        }

    }

    // map 中存 key 和 节点
    private HashMap<Integer, Node> hashMap;
    private NodeDoubleLinkedList list;
    private int capacity;

    public LRUCache(int capacity) {

        if (capacity < 1) {
            System.out.println("capacity should be larger than 1");
        } else {
            this.capacity = capacity;
        }
        this.hashMap = new HashMap<>();
        this.list = new NodeDoubleLinkedList();

    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node getNode = this.hashMap.get(key);
            this.list.deleteNodeAddToLast(getNode);
            return getNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node toBeUpdate = hashMap.get(key);
            toBeUpdate.value = value;
            this.list.deleteNodeAddToLast(toBeUpdate);
        } else {
            Node newNode = new Node(key, value);
            // 添加记录要保证 hashmap 也被更新
            this.hashMap.put(key, newNode);
            this.list.addLastNode(newNode);
            if (hashMap.size() == this.capacity + 1) {
                Node head = this.list.removeHead();
                this.hashMap.remove(head.key);
            }
        }
    }

}
