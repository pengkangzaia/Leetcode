package weeklytest.single.no227;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @FileName: No5673.java
 * @Description: No5673.java类说明
 * @Author: camille
 * @Date: 2021/2/7 13:03
 */
public class No5673 {

    public static int maximumScore(int a, int b, int c) {
        int[] nums = new int[] {a, b , c};
        Arrays.sort(nums);
        int res = 0;
        // 从最小值开始
        while (nums[0] > 0) {
            nums[0]--;
            res++;
            // 两个数比较大小，优先选择更大的那一个，并动态更新
            if (nums[1] > nums[2]) {
                nums[1]--;
            } else {
                nums[2]--;
            }
        }
        // 剩下的两个数中，最多只能有min(nums[1],nums[2])个操作
        res = res + (Math.min(nums[1], nums[2]));
        return res;
    }


}
