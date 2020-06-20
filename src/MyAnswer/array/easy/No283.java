package MyAnswer.array.easy;

public class No283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = i;
        while (i <= nums.length - 1) {
            if (nums[i] != 0) {
                i++;
            } else {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length - 1 && nums[j] == 0) {
                    return;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
            j = i;
        }
    }

}
