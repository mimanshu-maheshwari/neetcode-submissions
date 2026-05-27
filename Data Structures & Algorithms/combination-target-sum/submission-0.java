class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new HashSet<>();
        dfs(nums, target, 0, new ArrayList<>());
        return new ArrayList<>(result);

    }
    private void dfs(int[] nums, int target, int index, List<Integer> currResult) {
        if (0 == target) {
            result.add(new ArrayList<>(currResult));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        int value = nums[index];
        currResult.add(value);
        dfs(nums, target - nums[index], index, currResult);
        currResult.remove(currResult.size() - 1);
        dfs(nums, target, index + 1, currResult);
    }
}
