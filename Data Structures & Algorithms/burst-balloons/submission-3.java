record Key(int left, int right) {}
class Solution {
    public int maxCoins(int[] nums) {
        var list = new int[nums.length + 2];
        System.arraycopy(nums, 0, list, 1, nums.length);
        list[0] = 1;
        list[list.length - 1] = 1;
        var dp = new HashMap<Key, Integer>();

        return dfs(list, 1, list.length - 2, dp);
    }

    private int dfs(int[] list, int left, int right, HashMap<Key, Integer> dp) {
        if (left > right) {
            return 0;
        }
        var key = new Key(left, right);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int coins = 0;
        for (int i = left; i <= right; ++i) {
            coins = Math.max(coins, list[left - 1] * list[i] * list[right + 1] + 
            dfs(list, left, i - 1, dp) + dfs(list, i + 1, right, dp));
        }

        dp.put(key, coins);
        return dp.get(key);
    }
}
