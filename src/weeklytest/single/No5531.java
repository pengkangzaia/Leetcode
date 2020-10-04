package weeklytest.single;

import java.util.Arrays;

/**
 * @FileName: No5531.java
 * @Description: No5531.java类说明
 * @Author: camille
 * @Date: 2020/10/4 10:33
 */
public class No5531 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) {
                    if ((n-j) == i) {
                        return i;
                    }
                    break;
                }
            }
        }
        if (nums[0] >= n) {
            return n;
        }
        return -1;
    }

    public static void main(String[] args) {
        No5531 no5531 = new No5531();
        int i = no5531.specialArray(new int[]{0, 4, 3, 0, 4});
        System.out.println(i);
    }

}
