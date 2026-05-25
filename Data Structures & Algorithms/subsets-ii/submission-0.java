class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, List<Integer> currResult) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currResult));
            return;
        }

        // take one
        currResult.add(nums[index]);
        dfs(nums, index + 1, currResult);

        // not take one
        currResult.remove(currResult.size() - 1);
        dfs(nums, index + 1, currResult);
    }
}
