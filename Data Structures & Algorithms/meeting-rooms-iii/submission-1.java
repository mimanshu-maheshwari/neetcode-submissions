public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<long[]> available = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );
        for (int i = 0; i < n; i++) {
            available.offer(new long[]{0, i});
        }
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!available.isEmpty() && available.peek()[0] < start) {
                long[] earliest = available.poll();
                available.offer(new long[]{start, earliest[1]});
            }

            long[] room = available.poll();
            long endTime = room[0] + (end - start);
            available.offer(new long[]{endTime, room[1]});
            count[(int) room[1]]++;
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}