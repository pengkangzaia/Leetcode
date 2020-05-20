package sword2offer;

public class Question36 {

    // 不懂，之后还要回来看
    Node pre, head, tail;

    public void process(Node root) {
        if (root == null) return;
        process(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        tail = root;
        process(root.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        process(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

}
