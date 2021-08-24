package myanswer.array.medium;

/**
 * @author 彭康
 * @create 2021-08-21 21:56
 **/
public class BT1 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,6,4,2,2,1};
        int n = cal(nums);
        System.out.println(n);
    }

    private static int cal(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i < j) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            while (j <= n - 2 && nums[j] == nums[j + 1]) {
                j--;
            }
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] > nums[j]) {
                j--;
                res++;
            } else {
                i++;
                res++;
            }
        }
        // 判断中间元素是否重复
        if (nums[i] == nums[i + 1] || nums[i] == nums[i - 1]) {
            return res;
        } else {
            return res + 1;
        }
    }

}
