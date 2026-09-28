class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        
        for (int r = 0; r < n; r++) {
            // remove elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() < r - k + 1) {
                dq.pollFirst();
            }
            // remove smaller elements from the back — they can never be the max
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.offerLast(r);
            // window is full
            if (r >= k - 1) {
                result[r - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}