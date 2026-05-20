class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y) -> y[0] - x[0]);
        if (a > 0) {
            maxHeap.offer(new int[]{a, 'a'});
        }
        if (b > 0) {
            maxHeap.offer(new int[]{b, 'b'});
        }
        if (c > 0) {
            maxHeap.offer(new int[]{c, 'c'});
        }
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            if (result.length() > 1
             && result.charAt(result.length() - 1) == first[1] 
             && result.charAt(result.length() - 2) == first[1]) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] second = maxHeap.poll();
                result.append((char) second[1]);
                second[0]--;
                if (second[0] > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);
            } else {
                result.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) {
                    maxHeap.offer(first);
                }
            }
        }
        return result.toString();
    }
}