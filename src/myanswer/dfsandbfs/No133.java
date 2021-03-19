package myanswer.dfsandbfs;

import java.util.*;

/**
 * @FileName: No133.java
 * @Description: 克隆图
 * @Author: admin
 * @Date: 2021/3/18 13:48
 */
public class No133 {

    private HashMap<Integer, Node> map = new HashMap<>();

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        List<Node> neighbors = node.neighbors;
        if (neighbors == null || neighbors.size() <= 0) {
            return copy;
        }
        List<Node> copyNeighbors = copy.neighbors;
        for (Node neighbor : neighbors) {
            copyNeighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }


}
