package myanswer.linkedlist.hard;


/**
 * @FileName: No25.java
 * @Description: No25.java类说明
 * @Author: admin
 * @Date: 2020/11/11 9:30
 */
public class No25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // n是链表的长度
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        // 分成几个链表数组
        ListNode[] dummys = new ListNode[n / k];
        for (int i = 0; i < dummys.length; i++) {
            // 设置哑节点
            dummys[i] = new ListNode(-1);
        }
        // 结果链表的哑节点
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        curr = head;
        int idx = 0;
        while (curr != null) {
            int cnt = k;
            ListNode p = dummys[idx];
            while (cnt > 0 && curr != null) {
                // 头插法反转k个链表节点
                ListNode next = curr.next;
                curr.next = p.next;
                p.next = curr;
                curr = next;
                cnt--;
            }
            // 将子链表拼接到结果链表中
            res.next = dummys[idx].next;
            while (res.next != null) {
                res = res.next;
            }
            idx++;
            if (idx == n / k) {
                // 已经没有要反转的链表节点了
                res.next = curr;
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        No25 no25 = new No25();
        ListNode ans = no25.reverseKGroup(n1, 2);
        System.out.println(ans);
    }

    /**
     * 计算链表长度(获取子链表数组大小) -> 获取子链表数组 -> 设置子链表数组和结果链表的哑节点 ->
     * 翻转k个节点(头插法) -> 把翻转之后的子链表拼接到结果链表 ->
     * 当子链表数组已经全部翻转成功，将剩下的节点直接拼接到结果节点
     */

}
