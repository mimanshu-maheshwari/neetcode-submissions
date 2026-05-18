class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] str = s.toCharArray();
        int len = str.length;
        int[] charMap = new int[256];
        int left = -1;
        int maxLen = 1;
        for (int right = 0; right < len; ++right){
            char r = str[right];
            charMap[r]++;
            // shorten the window
            while (left < right && charMap[r] > 1) {
                char l = str[++left];
                charMap[l]--;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
