class Solution {
    public String longestPalindrome(String s) {
        // transformed string
        StringBuilder t = new StringBuilder("#");
        for (char c: s.toCharArray()) {
            t.append(c).append("#");
        }
        int n = t.length();
        // palaindromic length at i;
        int[] p = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            p[i] = (i < r) ? Math.min(r - i, p[(r - i) + l]) : 0;
            while (i + p[i] + 1 < n 
                  && i - p[i] - 1 >= 0 
                  && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                    p[i]++;
                  }
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
        int resLen = 0, center_idx = 0;
        for (int i = 0; i < p.length; ++i) {
            if (p[i] > resLen) {
                resLen = p[i];
                center_idx = i;
            }
        }
        int resIdx= (center_idx - resLen) >> 1;
        return s.substring(resIdx, resIdx + resLen);
    }
}
