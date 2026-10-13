record Key(int index, boolean canBuy){}
class Solution {
    private HashMap<Key, Integer> dp;
    public int maxProfit(int[] prices) {
        dp = new HashMap<Key, Integer>();
        return dfs(prices, 0, true);
    }
    public int dfs(
        int[] prices, 
        int index, 
        boolean canBuy
    ) {
        if (index >= prices.length) {
            return 0;
        }

        var key = new Key(index, canBuy);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int profit = 0;

        if (canBuy) {
            // buy
            profit = Math.max(profit, dfs(prices, index + 1, false) - prices[index]);
        } else {
            // sell
            profit = Math.max(profit, dfs(prices, index + 2, true) + prices[index]);
        }
        // do nothing for that price
        profit = Math.max(profit, dfs(prices, index + 1, canBuy));

        dp.put(key, profit);
        return profit;
    }
}
