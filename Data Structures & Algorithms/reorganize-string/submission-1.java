class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        if (maxFreq > ((s.length() + 1)>> 1)) {
            return "";
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            char c = (char) curr[0];
            int count = curr[1];
            if (result.length() > 0 && result.charAt(result.length() - 1) == c) {
                if (pq.isEmpty()){
                    return "";
                }
                int[] second = pq.poll();
                char sc = (char) second[0];
                result.append(sc);
                second[1]--;
                if (second[1] > 0){
                    pq.offer(second);
                }
                pq.offer(curr);
            }else {
                result.append(c);
                curr[1]--;
                if (curr[1] > 0){ 
                    pq.offer(curr);
                }
            }
        }
        return result.toString();
    }
}