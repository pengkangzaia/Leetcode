package weeklytest;

import java.util.*;

/**
 * @FileName: No5710.java
 * @Description: 积压订单中的订单总数
 * @Author: camille
 * @Date: 2021/3/21 10:40
 */
public class No5710 {


    public int getNumberOfBacklogOrders(int[][] orders) {
        // key为单价，value为数量
        TreeMap<Integer, Integer> buyBackLog = new TreeMap<>();
        TreeMap<Integer, Integer> sellBackLog = new TreeMap<>();
        for (int i = 0; i < orders.length; i++) {
            int[] order = orders[i];
            if (order[2] == 0) {
                // buy
                if (!sellBackLog.isEmpty() && (sellBackLog.firstKey() <= order[0])) {
                    while (!sellBackLog.isEmpty() && (sellBackLog.firstKey() <= order[0])) {
                        Map.Entry<Integer, Integer> entry = sellBackLog.firstEntry();
                        if (entry.getValue() > order[1]) {
                            sellBackLog.put(entry.getKey(), entry.getValue() - order[1]);
                            order[1] = 0;
                            break;
                        } else if (entry.getValue() == order[1]) {
                            sellBackLog.remove(entry.getKey());
                            order[1] = 0;
                            break;
                        } else {
                            order[1] -= entry.getValue();
                            sellBackLog.remove(entry.getKey());
                        }
                    }
                    // 如果还有剩
                    if (order[1] > 0) {
                        buyBackLog.put(order[0], order[1]);
                    }
                } else {
                    buyBackLog.put(order[0], buyBackLog.getOrDefault(order[0], 0) + order[1]);
                }
            } else {
                // sell
                if (!buyBackLog.isEmpty() && (buyBackLog.lastKey() >= order[0])) {
                    while (!buyBackLog.isEmpty() && (buyBackLog.lastKey() >= order[0])) {
                        Map.Entry<Integer, Integer> entry = buyBackLog.lastEntry();
                        if (entry.getValue() > order[1]) {
                            buyBackLog.put(entry.getKey(), entry.getValue() - order[1]);
                            order[1] = 0;
                            break;
                        } else if (entry.getValue() == order[1]) {
                            buyBackLog.remove(entry.getKey());
                            order[1] = 0;
                            break;
                        } else {
                            order[1] -= entry.getValue();
                            buyBackLog.remove(entry.getKey());
                        }
                    }
                    // 如果还有剩
                    if (order[1] > 0) {
                        sellBackLog.put(order[0], order[1]);
                    }
                } else {
                    if (sellBackLog.containsKey(order[0])) {
                        sellBackLog.put(order[0], sellBackLog.get(order[0]) + order[1]);
                    } else {
                        sellBackLog.put(order[0], order[1]);
                    }
                }
            }
        }
        // 返回剩余订单总数
        long res = 0;
        for (Integer value : buyBackLog.values()) {
            res = (res + value);
        }
        for (Integer value : sellBackLog.values()) {
            res += value;
        }
        return (int) (res % (1000000007));
    }

    public static void main(String[] args) {
        No5710 no5710 = new No5710();
        /*int[][] orders = {
                {7, 1000000000, 1},
                {15, 3, 0},
                {5, 999999995, 0},
                {5, 1, 1}
        };*/
        int[][] orders = {
                {1, 29, 1},
                {22, 7, 1},
                {24, 1, 0},
                {25, 15, 1},
                {18, 8, 1},
                {8, 22, 0},
                {25, 15, 1},
                {30, 1, 1},
                {27, 30, 0}};
        int ans = no5710.getNumberOfBacklogOrders(orders);
        System.out.println(ans);

    }

}
