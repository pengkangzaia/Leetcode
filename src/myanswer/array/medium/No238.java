package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No238.java
 * @Description: 除自身以外数组的乘积
 * @Author: admin
 * @Date: 2020/10/22 20:06
 */
public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int tem = 1;
        for (int i = 0; i < n; i++) {
            res[i] = tem;
            tem = tem * nums[i];
        }
        tem = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] *= tem;
            tem *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        No238 no238 = new No238();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] ans = no238.productExceptSelf1(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int temp = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = temp;
            temp = temp * nums[i];
        }
        temp = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = temp * res[i];
            temp = temp * nums[i];
        }
        return res;
    }

}
