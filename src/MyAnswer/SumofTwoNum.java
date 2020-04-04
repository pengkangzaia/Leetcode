package MyAnswer;
/*暴力解法
还有使用哈希表的方法。Marked ， 之后再看。
* */

public class SumofTwoNum {
    public static void main(String[] args) {
        int[] nums = {2, 7,5,1};
        int target = 9;
        int[] a = twoSum(nums,target);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }
        return a;
    }
}
