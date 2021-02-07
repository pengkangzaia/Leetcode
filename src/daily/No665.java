package daily;

/**
 * @FileName: No665.java
 * @Description: 非递减序列
 * @Author: admin
 * @Date: 2021/2/7 22:42
 */
public class No665 {

    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 递增的
        boolean flag = nums[0] <= nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) {
                    if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No665 no665 = new No665();
        int[] nums = {4,2,3};
        boolean ans = no665.checkPossibility(nums);
        System.out.println(ans);
    }


}
