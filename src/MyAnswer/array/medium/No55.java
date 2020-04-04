package MyAnswer.array.medium;

public class No55 {

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        boolean ans = canJump(a);
        System.out.println(ans);
    }

    public static boolean canJump(int[] nums) {
        int max_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max_index) return false;
            max_index = Math.max(max_index, i + nums[i]);
        }
        return true;
    }
}
