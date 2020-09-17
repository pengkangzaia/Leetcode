/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No77.java
 * @Description: No77.java类说明, 组合
 * @Author: kang.peng
 * @Date: 2020/9/8 22:13
 */
public class No77 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return res;
        } else if (n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = n; i >= 1; i--) {
                list.add(i);
            }
            res.add(list);
            return res;
        } else {
            for (int i = n; i >= k; i--) {

            }
            return combine(n - 1, k);
        }
    }

    // 1 2 3 4
    // 4 3 2
    // 4 3 1
    // 4 1
    // 3 2
    // 3 1
    // 2 1

    // 1 2 3
    // 3 2
    // 3 1
    // 2 1

    // 1 2

}
