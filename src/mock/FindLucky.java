package mock;

import java.util.HashMap;

/**
 * @FileName: FindLucky.java
 * @Description: FindLucky.java类说明
 * @Author: admin
 * @Date: 2021/3/1 19:06
 */
public class FindLucky {


    public int findLucky(int[] arr) {
        // 元素出现的频次等于元素的值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int res = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(key)) {
                res = Math.max(res, key);
            }
        }
        return res;
    }



}
