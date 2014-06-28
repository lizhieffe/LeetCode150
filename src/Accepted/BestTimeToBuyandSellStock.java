package Accepted;

public class BestTimeToBuyandSellStock {

	public int maxProfit(int[] prices) {
        int length = prices.length;
        
        if (length <= 1)
            return 0;
            
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < length; i ++) {
            if (prices[i] < min)
                min = prices[i];
            if (maxProfit < prices[i] - min)
                maxProfit = prices[i] - min;
        }
        
        return maxProfit;
    }
}
