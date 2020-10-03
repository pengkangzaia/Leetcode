package myanswer.linkedlist.medium;

public class No61 {

    // 2020/7/13 12:09 AC
    // corner case：k = (0,1,2..) * n 时 target为length，需对其特殊处理。
    public ListNode rotateRight(ListNode head, int k) {
        // 旋转链表
        // 先遍历一遍查找链表总长度 n
        // k % n = x 为倒数的第 x 个节点，此节点为要旋转的关键节点
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftFirst = head;
        ListNode curr = head;
        ListNode leftLast = null, rightFirst = null, rightLast = null;

        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }

        rightLast = head;

        int target = length - (k % length);
        // 有个 bug，当 target == length 时会有问题
        if (target == length) {
            return leftFirst;
        }
        while (curr != null) {
            target--;
            if (target == 0) {
                leftLast = curr;
            }
            if (target == -1) {
                rightFirst = curr;
                break;
            }
            curr = curr.next;
        }

        // 四个节点找到了，旋转链表
        rightLast.next = leftFirst;
        dummy.next = rightFirst;
        leftLast.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);
        No61 no61 = new No61();
        ListNode rotate = no61.rotateRight(node1, 5);
        System.out.println(rotate);
    }

}
