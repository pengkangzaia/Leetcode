package weeklytest;

import java.util.Arrays;

public class No5735 {

    public int maxIceCream(int[] costs, int coins) {
        // PriorityQueue<Integer> heap = new Prio
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                res++;
            } else {
                break;
            }
        }
        return res;

    }



}
