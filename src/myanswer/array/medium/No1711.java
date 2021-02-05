package myanswer.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @FileName: No1711.java
 * @Description: 大餐计数
 * @Author: admin
 * @Date: 2021/2/5 20:20
 */
public class No1711 {

    public int countPairs(int[] deliciousness) {
        // 会重复计算，要除以2
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            set.add(1 << i);
        }
        for (int i = 0; i < deliciousness.length; i++) {
            for (Integer sum : set) {
                if (map.containsKey(sum - deliciousness[i])) {
                    res += map.get(sum - deliciousness[i]);
                }
            }
            // map更新值，这一步真的超级重要！！！
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return res / 2;
    }

    public static void main(String[] args) {
        No1711 no1711 = new No1711();
        int[] nums = {1,3,5,7,9};
        int ans = no1711.countPairs(nums);
        System.out.println(ans);
    }


}
