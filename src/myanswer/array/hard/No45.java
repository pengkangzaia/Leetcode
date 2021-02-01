package myanswer.array.hard;

/**
 * @FileName: No45.java
 * @Description: 跳跃游戏2
 * @Author: admin
 * @Date: 2021/2/1 22:43
 */
public class No45 {

    // 官方题解方法1，从后向前优先找第一个能跳到当前位置的节点
    public int jump1(int[] nums) {
        int index = nums.length - 1;
        int step = 0;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (nums[i] + i >= index) {
                    step++;
                    index = i;
                    break;
                }
            }
        }
        return step;
    }

    // 官方题解2，从前向后查找
    // 维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
    // 相当于双重循环，一遍遍历数组中的元素，另一边求当前步数能够到达的最大值
    public int jump2(int[] nums) {
        int max_reach = 0; // 下一步步数能到达的最大值
        int end = 0, step = 0; // end表示当前步数能到达的最大值
        for (int i = 0; i < nums.length - 1; i++) { // 如果i是最后一个元素，那么就不需要再进入判断然后增加步数了
            max_reach = Math.max(max_reach, i + nums[i]); // 下一步能到达的最大值
            if (i == end) {
                end = max_reach; // 当前步数到达最大值后，跳到当前位置并将步数加1，更新end值
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        No45 no45 = new No45();
        int[] nums = new int[]{2,3,1,1,4};
        int ans = no45.jump2(nums);
        System.out.println(ans);
    }

}
