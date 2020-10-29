package daily;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * @FileName: No1207.java
 * @Description: No1207.java类说明
 * @Author: camille
 * @Date: 2020/10/28 20:32
 */
public class No1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int[] cnt = new int[map.size()];
        int idx = 0;
        for (Integer key : map.keySet()) {
            cnt[idx] = map.get(key);
            idx++;
        }
        Arrays.sort(cnt);
        for (int i = 0; i < cnt.length - 1; i++) {
            if (cnt[i] == cnt[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1207 no1207 = new No1207();
        int[] arr = {1,2,2,1,1,3};
        boolean ans = no1207.uniqueOccurrences(arr);
        System.out.println(ans);
    }

}
