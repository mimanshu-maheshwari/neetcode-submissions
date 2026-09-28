class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int len = nums.length;
        var maxHeap = new PriorityQueue<int[]>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        var result = new int[len - k + 1];
        int l = 0;
        int index = 0;
        for (int r = 0; r < len; ++r) {
            maxHeap.offer(new int[]{nums[r], r});
            if (r - l + 1 == k) {
                while(!maxHeap.isEmpty()) {
                    if (maxHeap.peek()[1] >= l){
                        result[index++] = maxHeap.peek()[0];
                        break;
                    } else {
                        maxHeap.poll();
                    }
                }
                l++;
            }
        }
        return result;
    }
}
