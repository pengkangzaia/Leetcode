package sword2offer;

public class Node {

    int val;
    Node next;
    Node random;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", random=" + random +
                '}';
    }
}
