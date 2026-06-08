class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        int maxLen = 0;
        for (int n: nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int k = n;
            while (set.contains(k)) {
                ++k;
            }
            maxLen = Math.max(maxLen, k - n);
        }
        return maxLen;
    }
}
