package mock;

import java.util.Random;

/**
 * @FileName: Solution.java
 * @Description: Solution.java类说明
 * @Author: admin
 * @Date: 2021/3/6 13:09
 */
public class Solution {

    int[] num;

    public Solution(int[] w) {
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
        }
        num = new int[sum];
        int idx = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                num[idx++] = i;
            }
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int a = r.nextInt(num.length);
        return num[a];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution solution = new Solution(nums);
        for (int i = 0; i < 12; i++) {
            int index = solution.pickIndex();
            System.out.println(index);
        }

    }


}
