package myanswer.array.easy;

import java.util.Arrays;

// 多数元素
public class No169 {

    // 排序法
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 摩尔计数法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate != nums[i]) {
                count--;
            } else {
                count++;
            }
            // 这里改为-1更好理解一点。我这边已经没有兵可以和其他人一换一了
            // 当又遇到敌人的时候，当前敌人的nums[i]就有可能是数组中的那个多数元素
            if (count == -1) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        No169 no169 = new No169();
        int ans = no169.majorityElement(nums);
        System.out.println(ans);
    }


    // 开始时间 2020/11/12 20点45分
    // 结束时间 2020/11/12
    public int majorityElement2(int[] nums) {
        // 摩尔计数
        int can = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (can != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count == -1) {
                can = nums[i];

            }

        }
        return count;
    }

}
