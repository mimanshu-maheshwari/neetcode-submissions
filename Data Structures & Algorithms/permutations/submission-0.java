class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        backtrack(nums, result, 0);
        return result;
    }

    private void backtrack(
        int[] nums,
        List<List<Integer>> result,
        int index
    ){
        if (index == nums.length) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            swap(nums, index, i);
            backtrack(nums, result, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
