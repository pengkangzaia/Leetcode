package myanswer.array.easy;

import java.util.HashSet;
import java.util.Set;

public class No136 {
    public static void main(String[] args) {
        int[] nums = {13,22,23,23,22};
        int ans = singleNumber(nums);
        int ans2 = singleNumberMethod2(nums);
        System.out.println(ans2);
    }

    private static int singleNumberMethod2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }

    private static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
