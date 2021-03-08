package mock;

import myanswer.linkedlist.easy.ListNode;
import myanswer.linkedlist.hard.No23;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: NextLargerNodes.java
 * @Description: NextLargerNodes.java类说明
 * @Author: admin
 * @Date: 2021/3/8 19:59
 */
public class NextLargerNodes {

    /**
     * We are given a linked list with head as the first node.
     * Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
     *
     * Each node may have a next larger value:
     * for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val,
     * and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
     *
     * Return an array of integers answer,
     * where answer[i] = next_larger(node_{i+1}).
     *
     * Note that in the example inputs (not outputs) below,
     * arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2,
     * second node value of 1, and third node value of 5.
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[]{0};
        }
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }
        int[] array = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            array[i] = nums.get(i);
        }

        int[] res = new int[array.length];

        // 单调栈解法
        Deque<Integer> stack = new LinkedList<>();
        // 从后往前压栈，如果当前节点比栈顶小则得到res，否则持续出栈直到栈为空或者栈顶大于当前节点
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(array[i]);
                res[i] = 0;
            } else if (stack.peek() > array[i]) {
                res[i] = stack.peek();
                stack.push(array[i]);
            }
        }
        return res;
    }


}
