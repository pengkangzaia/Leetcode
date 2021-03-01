package myanswer.array.easy;

/**
 * @FileName: No303.java
 * @Description: 区域和检索 - 数组不可变
 * @Author: admin
 * @Date: 2021/3/1 9:44
 */
public class No303 {

    static class NumArray {

        private int[] prefix;

        // 37
        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return prefix[j + 1] - prefix[i];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,2,3});
        System.out.println(numArray.sumRange(0,1));
        System.out.println(numArray.sumRange(0,2));
    }


}
