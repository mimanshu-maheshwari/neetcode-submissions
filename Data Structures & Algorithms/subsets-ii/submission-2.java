class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> currResult) {
        result.add(new ArrayList<>(currResult));
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // take one
            currResult.add(nums[i]);
            dfs(nums, i + 1, currResult);
            currResult.remove(currResult.size() - 1);
        }
    }
}
