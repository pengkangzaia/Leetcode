package weeklytest.contest216;

import java.util.ArrayList;

/**
 * @FileName: No1664.java
 * @Description: No1664.java类说明
 * @Author: admin
 * @Date: 2020/11/25 13:10
 */
public class No1664 {

    public int waysToMakeFair(int[] nums) {
        // 暴力法，会超时
        int n = nums.length;
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            Integer origin = list.remove(i);
            int odd = 0;
            int even = 0;
            for (int j = 0; j < list.size(); j++) {
                if (j % 2 == 0) {
                    odd += list.get(j);
                } else {
                    even += list.get(j);
                }
            }
            if (odd == even) {
                res++;
            }
            list.add(i, origin);
        }
        return res;
    }


}
