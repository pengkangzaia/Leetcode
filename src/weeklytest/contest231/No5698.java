package weeklytest.contest231;

/**
 * @FileName: No5698.java
 * @Description: No5698.java类说明
 * @Author: admin
 * @Date: 2021/3/7 12:37
 */
public class No5698 {

    // 构成特定和需要添加的最少元素

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long diff = goal - sum;
        long res = 0L;
        if (diff < 0) {
            diff = -1 * diff;
        }
        res = diff % limit == 0 ? (diff / limit) : (diff / limit) + 1;
        return (int) res;
    }


}
