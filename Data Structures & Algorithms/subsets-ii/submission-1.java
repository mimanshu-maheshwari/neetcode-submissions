class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return result;
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
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, index + 1, currResult);
    }
}
