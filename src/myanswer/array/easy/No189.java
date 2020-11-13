package myanswer.array.easy;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 旋转环状数组
public class No189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 2;
        /*rotateOnce(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }*/
        rotate2(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    //解法2：使用环状替换
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    //解法1：执行用时 :358 ms
    //在所有 Java 提交中击败了5.00%的用户
/*    private static void rotate(int[] nums, int k) {
        while (k>=1){
            rotateOnce(nums);
            k--;
        }

    }

    private static void rotateOnce(int[] nums) {

        int temp;
        for (int i = nums.length - 1; i >= 1; i--) {
            temp = nums[i-1];
            nums[i-1] = nums[i];
            nums[i] = temp;
        }
    }*/








    public static void rotate1(int[] nums, int k) {
        while (k > 0) {
            shift(nums);
            k--;
        }
    }

    private static void shift(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }

    }

    // 利用反转的解法
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


}
