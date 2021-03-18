package daily;

/**
 * @FileName: No92.java
 * @Description: 反转链表2
 * @Author: admin
 * @Date: 2021/3/18 9:27
 */
public class No92 {


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        int m = left, n = right;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummyReverse = new ListNode(-1);
        dummy1.next = head;

        int currIndex = 1;
        ListNode curr = head;
        ListNode prev = dummy1;
        ListNode next = curr.next;

        // 找到反转的开始位置
        while (curr != null && currIndex < m) {
            prev = curr;
            curr = curr.next;
            next = curr.next;
            currIndex++;
        }

        // 开始反转
        ListNode dummyReverseTail = new ListNode(-1);
        while (curr != null && currIndex <= n) {
            if (currIndex == m) {
                dummyReverseTail = curr;
            }
            currIndex++;
            ListNode currReverse = dummyReverse.next;
            dummyReverse.next = curr;
            curr.next = currReverse;
            curr = next;
            if (curr != null) {
                // curr被赋值为null之后可能为空
                next = curr.next;
            }
        }

        // prev -> dummyReverse.next -> dummyReverseTail -> curr
        prev.next = dummyReverse.next;
        dummyReverseTail.next = curr;
        return dummy1.next;
    }

    public static void main(String[] args) {
        No92 no92 = new No92();
        ListNode n1 = no92.new ListNode(1);
        ListNode n2 = no92.new ListNode(2);
        ListNode n3 = no92.new ListNode(3);
        ListNode n4 = no92.new ListNode(4);
        ListNode n5 = no92.new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode ans = no92.reverseBetween(n1, 1, 3);
        System.out.println(ans);
    }

}
