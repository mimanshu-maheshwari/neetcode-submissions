class Solution {
    public boolean carPooling(int[][] trips, final int capacity) {
        Arrays.sort(trips, Comparator.comparing(a -> a[1]));
        // (end, current passenger count)
        var pq = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0]));
        int curOccupancy = 0;
        for (int[] trip: trips) {
            int passengers = trip[0], 
                start = trip[1],
                end = trip[2];
            
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                curOccupancy -= pq.poll()[1];
            }

            curOccupancy += passengers;
            if (curOccupancy > capacity) {
                return false;
            }
            pq.offer(new int[]{end, passengers});
        }
        return true;
    }
}