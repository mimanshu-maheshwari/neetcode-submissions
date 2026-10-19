class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int n : nums) sum += n;
    if (sum % k != 0) return false;
    
    int target = sum / k;
    Arrays.sort(nums);  // ascending for early termination
    if (nums[nums.length - 1] > target) return false;
    
    // memo[visited] = can we partition the remaining elements?
    Boolean[] memo = new Boolean[1 << nums.length];
    return backtrack(nums, target, 0, 0, k, memo);
}

private boolean backtrack(int[] nums, int target, int visited, int currSum, int k, Boolean[] memo) {
    if (k == 0) return true;
    if (currSum == target) return backtrack(nums, target, visited, 0, k - 1, memo);
    if (memo[visited] != null) return memo[visited];
    
    for (int i = 0; i < nums.length; i++) {
        if ((visited & (1 << i)) != 0) continue;
        if (currSum + nums[i] > target) break;  // sorted: no point continuing
        if (i > 0 && nums[i] == nums[i-1] && (visited & (1 << (i-1))) == 0) continue; // skip duplicates
        visited |= (1 << i);
        if (backtrack(nums, target, visited, currSum + nums[i], k, memo)) return true;
        visited &= ~(1 << i);
    }
    memo[visited] = false;
    return false;
}
}