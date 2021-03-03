package mock;

/**
 * @FileName: MaxProduct.java
 * @Description: MaxProduct.java类说明
 * @Author: admin
 * @Date: 2021/3/1 19:34
 */
public class MaxProduct {

    /**
     * 给你一个整数数组 nums ，
     * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
     * 并返回该子数组所对应的乘积。
     */

    public int maxProduct(int[] nums) {
        int maxValue = 1; // 前面元素的累乘最大值
        int minValue = 1; // 前面元素的累乘最小值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(Math.max(minValue * nums[i], maxValue * nums[i]), nums[i]);
            minValue = Math.min(Math.min(minValue * nums[i], maxValue * nums[i]), nums[i]);
            res = Math.max(maxValue, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProduct product = new MaxProduct();
        int[] nums = {-2,0,2};
        int ans = product.maxProduct(nums);
        System.out.println(ans);
    }




}
