package MyAnswer.array.easy;

import java.util.LinkedList;
import java.util.List;

public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 如果当前值nums[i]=i，i++
        // else if (nums[i] == nums[nums[i]]) i++
        // else swap
        int temp = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                // continue;
            } else if (nums[i] == nums[nums[i] - 1]) {
                i++;
                // continue;
            } else {
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int j = 0; j <= nums.length - 1; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No448 no448 = new No448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = no448.findDisappearedNumbers(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }


}
