/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package weeklytest;

import java.util.HashMap;

/**
 * @FileName: No5512.java
 * @Description: No5512.java类说明
 * @Author: kang.peng
 * @Date: 2020/9/13 13:45
 */
public class No5512 {

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int res = 0;
        // pairs转hashmap
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        // 判断是否不开心
        for (int i = 0; i < n; i++) {
            // 第i个人的配对朋友
            Integer pairedFriend = map.get(i);
            for (int j = 0; j < n - 1; j++) {
                int currCheckFriend = preferences[i][j];
                if (pairedFriend == currCheckFriend) {
                    break;
                } else {
                    // a为当前要测的人的preference中，当前要测的人的配对朋友的位置
                    // b为当前要测的人的preference中，第i个人的位置
                    int a = 0, b = 0;
                    int currCheckFriendPairedFriend = map.get(currCheckFriend);
                    for (int k = 0; k < n - 1; k++) {
                        if (currCheckFriendPairedFriend == preferences[currCheckFriend][k]) {
                            a = k;
                        }
                        if (i == preferences[currCheckFriend][k]) {
                            b = k;
                        }
                    }
                    if (b < a) {
                        // 检测到不高兴之后，不需要再判断后面没检测过的是不是不符合。
                        // 因为一个人只能不高兴一次
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs = {{1, 3}, {0, 2}};
        int ans = unhappyFriends(n, preferences, pairs);
        System.out.println(ans);
    }


}
