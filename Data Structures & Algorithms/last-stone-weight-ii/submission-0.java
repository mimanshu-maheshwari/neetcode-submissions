record Key(int index, int currSum){}
class Solution {

    int target, 
        total;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }
        this.total = sum;
        this.target = (sum + 1) / 2;
        HashMap<Key, Integer> dp = new HashMap<>();
        return dfs(stones, dp, 0, 0);
    }

    private int dfs(int[] nums, HashMap<Key, Integer> dp, int index, int currSum) {
        if (currSum >= this.target || index == nums.length) {
            return Math.abs(currSum - (total - currSum));
        }

        Key key = new Key(index, currSum);

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int result = Math.min(
            // include it
            dfs(nums, dp, index + 1, currSum + nums[index]),
            // exclude it
            dfs(nums, dp, index + 1, currSum)
        );
        dp.put(key, result);

        return result;
    }
}