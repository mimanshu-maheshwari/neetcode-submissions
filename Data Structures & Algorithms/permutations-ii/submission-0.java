class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> currList = Arrays.stream(nums).boxed().toList();
        permute(nums, 0, new ArrayList<>(currList));
        return new ArrayList<>(this.result);
    }
    private void permute(int[]nums, int currIndex, List<Integer> currResult) {
        if (currIndex == nums.length) {
            this.result.add(new ArrayList<>(currResult));
            return;
        }
        for (int i = currIndex; i < nums.length; ++i) {
            // swap 
            int temp = currResult.get(i);
            currResult.set(i, currResult.get(currIndex));
            currResult.set(currIndex, temp);

            // recurse
            permute(nums, currIndex + 1, currResult);

            // reset
            temp = currResult.get(i);
            currResult.set(i, currResult.get(currIndex));
            currResult.set(currIndex, temp);
        }
    }
}