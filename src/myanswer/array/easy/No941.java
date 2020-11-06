package myanswer.array.easy;

/**
 * @FileName: No941.java
 * @Description: No941.java类说明
 * @Author: admin
 * @Date: 2020/11/3 16:13
 */
public class No941 {

    public static boolean validMountainArray(int[] nums) {
        // 思路清晰，我是钻一
        int n = nums.length;
        int i = 0;
        while (i + 1 <= n - 1 && nums[i] < nums[i+1]) {
            i++;
        }
        if (i == 0 || i == n-1) {
            return false;
        }
        while (i + 1 <= n - 1 && nums[i] > nums[i+1]) {
            i++;
        }
        return i == n-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        boolean ans = validMountainArray(nums);
        System.out.println(ans);
    }

}
