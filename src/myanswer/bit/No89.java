package myanswer.bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No89.java
 * @Description: 格雷编码
 * @Author: admin
 * @Date: 2020/10/22 14:22
 */
public class No89 {

    public List<Integer> grayCode(int n) {
        int range = 1 << n; // 2的n次方
        List<Integer> res = new ArrayList<>(range);
        res.add(0);
        // 已添加元素
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (res.size() < range) {
            int num = res.get(res.size() - 1);
            // 每次变一位,最多变n次
            for (int i = 0; i < n; i++) {
                // 110 -> 111   001
                // 110 -> 100   010
                // 110 -> 010   100
                int tem = (1 << i) ^ num;
                if (!set.contains(tem)) {
                    res.add(tem);
                    set.add(tem);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*System.out.println(1 << 0);
        System.out.println(1 << 1); // 2的一次方
        System.out.println(1 << 2); // 2的2次方
        System.out.println(1 << 3); // 2的3次方
        System.out.println(1 << 4); // 2的4次方*/
        No89 no89 = new No89();
        List<Integer> ans = no89.grayCode(3);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }


}
