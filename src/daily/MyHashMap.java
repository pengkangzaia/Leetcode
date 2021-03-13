package daily;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @FileName: MyHashMap.java
 * @Description: MyHashMap.java类说明
 * @Author: camille
 * @Date: 2021/3/14 1:12
 */
public class MyHashMap {

    LinkedList<Node>[] table;

    private int hash(int key) {
        return key % 1000;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new LinkedList[1000];
        for (int i = 0; i < 1000; i++) {
            table[i] = new LinkedList<Node>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        for (int i = 0; i < table[idx].size(); i++) {
            Node currNode = table[idx].get(i);
            if (currNode.key == key) {
                currNode.value = value;
                return;
            }
        }
        table[idx].add(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        for (int i = 0; i < table[idx].size(); i++) {
            Node currNode = table[idx].get(i);
            if (currNode.key == key) {
                return currNode.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hash(key);
        Iterator<Node> iterator = table[idx].iterator();
        while (iterator.hasNext()) {
            Node currNode = iterator.next();
            if (currNode.key == key) {
                iterator.remove();
            }
        }
    }

    class Node {
        int key;
        int value;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

}
