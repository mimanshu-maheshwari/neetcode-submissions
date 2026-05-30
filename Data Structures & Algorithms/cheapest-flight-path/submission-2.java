class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford 
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= k; ++i) {
            int[] tempPrices = Arrays.copyOfRange(prices, 0, n);
            for (int[] flight: flights) {
                int s = flight[0], d = flight[1], p = flight[2];
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + p < tempPrices[d]) {
                    tempPrices[d] = prices[s] + p;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}