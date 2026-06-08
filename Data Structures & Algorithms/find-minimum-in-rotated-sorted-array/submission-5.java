class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int res = nums[0];
        while (l <= r) {
            // this is sorted part
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = l + ((r - l) >> 1);
            res = Math.min(res, nums[m]);
            // left half is sorted move to right
            if (nums[m] >= nums[l]) {
                l = m + 1;
            }
            // search in left half (unsorted half)
            else {
                r = m - 1;
            }
            
        }
        return res;
    }
}
