class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        for (char c: tasks) {
            freqMap[c - 'A']++;
        }
        Arrays.sort(freqMap);
        int maxf = freqMap[25];
        int idle = (maxf - 1) * n;
        for (int i = 24; i >= 0; --i) {
            idle -= Math.min(maxf - 1, freqMap[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}
