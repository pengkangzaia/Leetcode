package sword2offer;

public class Question52 {

    // 输入两个链表，找出它们的第一个公共节点。
    // 双指针，a指针遍历A，b指针遍历B。当到达链表末尾，a指针指向B的头节点，b指针指向A的头节点

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果指针相遇，返回相遇节点
        // 如果不相遇，返回null
        if (headA == null || headB == null) {
            return null;
        }

        int n = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            currA = currA.next;
            n++;
        }
        while (currB != null) {
            currB = currB.next;
            n++;
        }

        currA = headA;
        currB = headB;
        int i = 0;
        while (currA != currB && i < n) {
            currA = currA.next;
            currB = currB.next;
            i++;
            if (currA == null) {
                currA = headB;
            }
            if (currB == null) {
                currB = headA;
            }
        }
        if (currA == currB) {
            return currA;
        } else {
            return null;
        }
    }

}
