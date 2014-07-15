package Accepted;

public class BestTimeToButAndSellStockIII {
	public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        int[] dpFromStart = new int[prices.length];
        int[] dpTillEnd = new int[prices.length];
        dpFromStart[0] = 0;
        dpTillEnd[prices.length - 1] = 0;
        
        int tmp = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < buyPrice)
                buyPrice = prices[i];
            else
                tmp = Math.max(tmp, prices[i] - buyPrice);
            
            dpFromStart[i] = tmp;
        }
        
        tmp = 0;
        int sellPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i --) {
            if (prices[i] > sellPrice)
                sellPrice = prices[i];
            else
                tmp = Math.max(tmp, sellPrice - prices[i]);
            
            dpTillEnd[i] = tmp;
        }
        
        int max = 0;
        for (int i = 0; i < prices.length - 1; i ++)
            max = Math.max(max, dpFromStart[i] + dpTillEnd[i + 1]);
        max = Math.max(max, dpFromStart[prices.length - 1]);
        return max;
    }
	
	public static void main(String[] args) {
		int[] prices = {2, 1, 2, 0, 1};
		BestTimeToButAndSellStockIII service =
				new BestTimeToButAndSellStockIII();
		int result = service.maxProfit(prices);
		
		System.out.println(result);
	}
}
