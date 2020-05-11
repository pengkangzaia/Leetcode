package sword2offer;

import java.util.HashMap;

public class Question35 {

    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        Question35 question35 = new Question35();
        Node ans = question35.copyRandomList(n0);
        System.out.println(ans);
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node,Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node newP = map.get(p);
            newP.next = p.next;
            newP.random = p.random;
            p = p.next;
        }

        return map.get(head);

    }

}
