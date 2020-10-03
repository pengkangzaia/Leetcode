package myanswer.array.easy;

public class No122 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 2, 3, 5, 10, 5, 4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }

    //leetcode的答案
    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
