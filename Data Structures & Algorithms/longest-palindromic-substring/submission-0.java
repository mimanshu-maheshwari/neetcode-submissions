class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        int l = 0, r = 0;
        for (int i = 0; i < len; ++i ){ 
            int left = i; 
            int right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    l = left;
                    r = right;
                }
                left--;
                right++;
            }
            left = i; 
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    l = left;
                    r = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(l, r + 1);
    }
}
