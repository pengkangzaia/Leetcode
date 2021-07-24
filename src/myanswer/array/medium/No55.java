package myanswer.array.medium;

public class No55 {

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        boolean ans = canJump(a);
        System.out.println(ans);
    }

    public static boolean canJump(int[] nums) {
        // 如果一个位置能够到达，那么这个位置左侧所有位置都能到达
        int max_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max_index) return false;
            max_index = Math.max(max_index, i + nums[i]);
        }
        return true;
    }
}
