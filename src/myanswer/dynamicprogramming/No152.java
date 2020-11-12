package myanswer.dynamicprogramming;

/**
 * @FileName: No152.java
 * @Description: 乘积最大数组
 * @Author: camille
 * @Date: 2020/10/14 22:23
 */
public class No152 {

    //标签：动态规划
    //遍历数组时计算当前最大值，不断更新
    //令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
    //由于存在负数，那么会导致最大的变最小的，最小的变最大的。
    //因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    //当负数出现时则imax与imin进行交换再进行下一步计算


    // imax表示以当前节点为终止节点的连续子数组的乘积最大值
    // imin表示以当前节点为终止节点的连续子数组的乘积最小值

    // 多琢磨
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-10};
        No152 no152 = new No152();
        int ans = no152.maxProduct(nums);
        System.out.println(ans);
    }

    public int maxProduct1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = -1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = max;
                max = min;
                min = temp;
            }
            // 选择之前的节点 max*nums[i]
            // 不选择之前的节点 nums[i]
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            // max是当前节点的最大值
            // res是所有节点的最大值
            res = Math.max(res, max);
        }
        return res;

    }


}
