class Solution {
    public boolean carPooling(int[][] trips, final int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];   // passengers board
            diff[trip[2]] -= trip[0];   // passengers alight
        }
        int current = 0;
        for (int occupancy : diff) {
            current += occupancy;
            if (current > capacity) return false;
        }
        return true;
    }
}