package daily;

import java.util.HashSet;

/**
 * @FileName: No349.java
 * @Description: No349.java类说明
 * @Author: admin
 * @Date: 2020/11/2 13:52
 */
public class No349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        Object[] objects = res.toArray();
        int[] ans = new int[res.size()];
        for (int i = 0; i < objects.length; i++) {
            ans[i] = (int) objects[i];
        }
        return ans;
    }

}
