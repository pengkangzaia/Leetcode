package sword2offer;

public class Question56_1 {

    /*
     * 一个整型数组 nums 里除两个数字之外，
     * 其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，
     * 空间复杂度是O(1)。
     * */

    // 位运算，异或
    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        int a = -diff;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question56_1 question56_1 = new Question56_1();
        int[] ans = question56_1.singleNumbers(new int[]{4, 1, 4, 6});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
