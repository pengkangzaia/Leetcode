package sword2offer;

public class Question63 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(Math.max(0, prices[i] - min), profit);
        }
        return profit;
    }

}
