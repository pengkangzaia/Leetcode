package myanswer.array.easy;

/**
 * @FileName: No219.java
 * @Description: 存在重复元素2
 * @Author: admin
 * @Date: 2021/1/4 10:12
 */
public class No219 {

    // 超时
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (0 <= j && j < nums.length && i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 用hashset
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        return false;
    }

}
