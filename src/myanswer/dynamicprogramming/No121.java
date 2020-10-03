package myanswer.dynamicprogramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No121 {
    public static void main(String[] args) {
        int[] nums = {7,6,4,3,2,1,10,12,11,15,2,6,2,4};
        int ans = maxProfit(nums);
        System.out.println(ans);
    }

    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxProfit = maxProfit < prices[i+1] - minPrice ? prices[i + 1] - minPrice : maxProfit;
        }
        return maxProfit;
    }
}
