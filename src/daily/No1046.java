package daily;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @FileName: No1046.java
 * @Description: 最后一块石头的重量
 * @Author: admin
 * @Date: 2020/12/30 8:40
 */
public class No1046 {


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while (queue.size() >= 2) {
            Integer big = queue.poll();
            Integer small = queue.poll();
            int diff = big - small;
            if (diff > 0) {
                queue.offer(diff);
            }
        }
        if (queue.size() == 1) {
            return queue.peek();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        No1046 no1046 = new No1046();
        int[] stones = {2,7,4,1,8,1};
        int ans = no1046.lastStoneWeight(stones);
        System.out.println(ans);
    }


}
