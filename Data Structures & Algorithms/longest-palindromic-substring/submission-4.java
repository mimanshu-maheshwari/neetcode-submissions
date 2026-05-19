class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c: s.toCharArray()) sb.append(c).append("#");

        int n = sb.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        int bestCenter = 0, bestLen = 0;
        for (int i = 0; i < n; ++i) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(p[mirror], right - 1);
            }
            while (i + p[i] + 1 < n && i - (p[i] + 1) >= 0 && 
            sb.charAt(i + p[i] + 1) == sb.charAt(i - (p[i] + 1))) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (bestLen < p[i]) {
                bestCenter = i;
                bestLen = p[i];
            }
        }
        int start = (bestCenter - bestLen) >> 1; 
        return s.substring(start, start + bestLen);
    }
}
