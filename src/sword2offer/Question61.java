package sword2offer;

import java.util.Arrays;

public class Question61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int diff;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            diff = nums[i+1] - nums[i];
            if (diff == 0) {
                return false;
            } else if (diff == 1) {
                continue;
            } else {
                count -= diff - 1;
            }
        }
        return (count==0);
        // return nums[4] - nums[count] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

}
