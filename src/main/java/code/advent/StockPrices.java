package code.advent;

public class StockPrices {
    public int maxProfit(int[] prices) {
        int retval = 0;
        if (prices.length < 2) {
            return retval;
        }
        int min = prices[0];
        int max = -1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = min;
            } else {
                max = Math.max(prices[i], max);
                retval = Math.max(retval, max - min);
            }
        }
        return retval;
    }
}
