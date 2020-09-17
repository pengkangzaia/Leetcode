package MyAnswer.linkedlist.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No23 {

    /** 大佬的写法
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 优先队列实现
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            node = node.next;
            if (node != null) {
                queue.add(node);
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }



}
