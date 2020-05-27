package datastructure;

public class BinaryTree {

    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        root.preOrder();
    }

    public void midOrder() {
        root.midOrder();
    }

    public void postOrder() {
        root.postOrder();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, "刘备");
        Node node2 = new Node(2, "关羽");
        Node node3 = new Node(3, "张飞");
        Node node4 = new Node(4, "赵云");
        Node node5 = new Node(5, "马超");

        node1.setLeft(node2);
        node1.setRight(node3);

        node3.setLeft(node4);
        node3.setRight(node5);

        BinaryTree bt = new BinaryTree(node1);
        bt.preOrder();
        System.out.println("=========================");
        bt.midOrder();
        System.out.println("=========================");
        bt.postOrder();
        System.out.println("=========================");
    }

}
