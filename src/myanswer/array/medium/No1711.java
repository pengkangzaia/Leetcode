package myanswer.array.medium;

import java.util.*;

/**
 * @FileName: No1711.java
 * @Description: 大餐计数
 * @Author: admin
 * @Date: 2021/2/5 20:20
 */
public class No1711 {

    public int countPairs(int[] deliciousness) {
        // 会重复计算，要除以2
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j < 22; j++) {
                int sum = 1 << j;
                if (map.containsKey(sum - deliciousness[i])) {
                    res += map.get(sum - deliciousness[i]);
                }
            }
            // map更新值，这一步真的超级重要！！！
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        No1711 no1711 = new No1711();
        //int[] nums = {32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32};
        int[] nums = {64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64};
        int ans = no1711.countPairs1(nums);
        System.out.println(ans);
    }


    public int countPairs1(int[] deliciousness) {
        HashSet<Integer> set = new HashSet<>();
        int num = 1;
        for (int i = 0; i < 31; i++) {
            set.add(num);
            num = num << 1;
        }
        Arrays.sort(deliciousness);
        int n = deliciousness.length;
        long res = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.contains(deliciousness[i] + deliciousness[j])) {
                    res++;
                }
            }
        }
        long temp = 1000000007;
        res = res % (temp);
        System.out.println(temp);
        return (int) res;
    }


}
