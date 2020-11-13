package myanswer.array.medium;

/**
 * @FileName: No334.java
 * @Description: 递增的三元子序列
 * @Author: admin
 * @Date: 2020/11/13 14:37
 */
public class No334 {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 需要考虑数组中元素都为一样的情况。比如[1,1,1,1,1,1,1,1,1,1,1]
            // 如果是小于才更新的话会返回true。所以等于时也要同步更新small，mid值
            if (nums[i] <= small) {
                small = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

}
