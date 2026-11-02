class Solution {
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        // preproduct 
        var result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // post product 
        int post = 1;
        for (int i = len - 1; i >= 0; --i) {
            result[i] *= post;
            post *= nums[i];
        }
        return result;
    }
}  
