package Accepted;

public class BestTimeToBuyAndSellStockII {
	
	public int maxProfit(int[] prices) {
		int length = prices.length;
		
		if (length <= 1)
			return 0;
		
		boolean haveStock = false;
		int buyPrice = 0;
		int profit = 0;
		
		for (int i = 0; i < length - 1; i ++) {
			if (prices[i] < prices[i + 1]) {
				if (haveStock == false) {
					buyPrice = prices[i];
					haveStock = true;
				}
			}
			else if (prices[i] > prices[i + 1]) {
				if (haveStock == true) {
					profit = profit + prices[i] - buyPrice;
					haveStock = false;
				}
					
			}
		}
		
		if (prices[length - 1] > buyPrice && haveStock == true)
			profit = profit + prices[length - 1] - buyPrice;
		
		return profit;
    }
}
