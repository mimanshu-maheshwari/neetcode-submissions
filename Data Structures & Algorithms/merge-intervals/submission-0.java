class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );
        int[] curr = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; ++i) {
            if (curr[1] >= intervals[i][0]) {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                result.add(curr);
                curr = intervals[i];
            }
        }
        result.add(curr);
        return result.toArray(new int[result.size()][2]);
    }
}
