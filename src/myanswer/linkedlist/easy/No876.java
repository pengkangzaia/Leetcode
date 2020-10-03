package myanswer.linkedlist.easy;

public class No876 {

    public ListNode middleNode(ListNode head) {
        //遍历一遍获取总的节点数量
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int middle = 0;
        //如果节点数量为奇数，则取中间值
        if (count % 2 == 1) {
            middle = (count + 1) / 2;
        } else {
            //如果节点数量为偶数，则取中间值靠后的那一个
            middle = (count / 2) + 1;
        }
        //再遍历一遍获取中间节点
        ListNode findMid = head;
        //起点为第一个节点，跳到第middle个节点需要跳middle-1次
        while (middle != 1) {
            middle--;
            findMid = findMid.next;
        }

        return findMid;
    }

}
