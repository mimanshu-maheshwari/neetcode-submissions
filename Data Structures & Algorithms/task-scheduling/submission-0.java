class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c: tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c: count) {
            if (c > 0) {
                maxHeap.offer(c);
            }
        }

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int c = maxHeap.poll() - 1;
                if (c > 0) {
                    queue.offer(new int[]{c, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
