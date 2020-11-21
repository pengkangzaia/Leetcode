package myanswer.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: No118.java
 * @Description: 杨辉三角
 * @Author: camille
 * @Date: 2020/11/20 21:26
 */
public class No118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            temp[0] = 1;
            temp[i] = 1;
            for (int j = 1; j < i; j++) {
                temp[j] = res.get(i-1).get(j-1) + res.get(i-1).get(j);
            }
            res.add(Arrays.asList(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        No118 no118 = new No118();
        List<List<Integer>> ans = no118.generate(5);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

}
