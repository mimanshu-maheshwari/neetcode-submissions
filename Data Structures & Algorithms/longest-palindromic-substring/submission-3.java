class Solution {
    public String longestPalindrome(String s) {
        // Transform: "abc" → "#a#b#c#"

        StringBuilder sb = new  StringBuilder("#");

        for (char c : s.toCharArray()) sb.append(c).append("#");

        String t = sb.toString();

        int n = t.length();

        int[] p = new  int[n];

        int c = 0, r = 0;

        int bestCenter = 0, bestLen = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * c - i;
            if (i < r) p[i] = Math.min(p[mirror], r - i);

            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0
                && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1))
                p[i]++;

            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            if (p[i] > bestLen) {
                bestCenter = i;
                bestLen = p[i];
            }
        }

        int start = (bestCenter - bestLen) / 2;

        return s.substring(start, start + bestLen);
    }
}
