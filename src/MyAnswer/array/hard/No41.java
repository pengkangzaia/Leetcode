package MyAnswer.array.hard;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class No41 {
    public static void main(String[] args) {
        int[] nums = {1, 2,0};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }


    /**
     * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * 如果 nums = [1]，答案即为 2 。
     * 将负数，零，和大于 n 的数替换为 1 。
     * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
     * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * 再次遍历数组。返回第一个正数元素的下标。
     * 如果 nums[0] > 0，则返回 n 。
     * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int firstMissingPositive(int[] nums) {
        boolean flag = true;
        for (int num : nums) {
            if (num == 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return 1;
        }


        if (nums[0] == 1 && nums.length == 1) {
            return 2;
        }

        //将负数，零，和大于 n 的数替换为 1 。
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0||nums[i]>nums.length){
                nums[i] = 1;
            }
        }

        //遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
        //注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a == nums.length) {
                nums[0] = -1 * Math.abs(nums[0]);
            }else {
                nums[a] = -1 * Math.abs(nums[a]);
            }

        }

        //再次遍历数组。返回第一个正数元素的下标。
        //如果 nums[0] > 0，则返回 n 。
        //如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length + 1;


    }


}
