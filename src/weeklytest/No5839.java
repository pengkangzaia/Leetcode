package weeklytest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 彭康
 * @create 2021-08-08 11:32
 **/
public class No5839 {

    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < piles.length; i++) {
            heap.offer(piles[i]);
        }
        int res = 0;
        while (k > 0) {
            Integer poll = heap.poll();
            heap.offer(poll % 2 == 0 ? poll / 2 : poll / 2 + 1);
            k--;
        }
        while (!heap.isEmpty()) {
            res += heap.poll();
        }
        return res;

    }


    public static void main(String[] args) {
        No5839 no5839 = new No5839();
        int[] piles = {4,3,6,7};
        int k = 3;
        int ans = no5839.minStoneSum(piles, k);
        System.out.println(ans);
    }


}
