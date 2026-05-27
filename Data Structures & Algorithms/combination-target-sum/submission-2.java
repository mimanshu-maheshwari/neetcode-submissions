class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(result);

    }
    private void dfs(int[] nums, int target, int index, int total, List<Integer> currResult) {
        if (total == target) {
            result.add(new ArrayList<>(currResult));
            return;
        }
        for(int i = index; i < nums.length; ++i) {
            if (nums[i] + total > target) {
                return;
            }
            currResult.add(nums[i]);
            dfs(nums, target, i, total + nums[i], currResult);
            currResult.remove(currResult.size() -1);
        }
    }
}
