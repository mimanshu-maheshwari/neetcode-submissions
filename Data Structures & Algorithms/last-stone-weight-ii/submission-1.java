record Key(int index, int currSum){}
class Solution {

    int target = 0, 
        total  = 0;

    public int lastStoneWeightII(int[] stones) {
        for (int stone: stones) {
            this.total += stone;
        }
        this.target = (this.total + 1) / 2;
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