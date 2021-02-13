package myanswer.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No119.java
 * @Description: 杨辉三角2
 * @Author: admin
 * @Date: 2021/1/4 9:18
 */
public class No119 {
    // 第0行，才是 1
    // 第1行，是从 1 1开始
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            nums[i] = 1; // 最后一个
            for (int j = i - 1; j > 0; j--) {
                nums[j] = nums[j - 1] + nums[j];
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        No119 no119 = new No119();
        for (int i = 1; i < 33; i++) {
            List<Integer> row = no119.getRow(i);
            System.out.println(row);
        }
    }


}
