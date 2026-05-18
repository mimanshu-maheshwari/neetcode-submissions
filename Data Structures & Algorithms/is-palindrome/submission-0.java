class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        char[] arr = s.toCharArray();
        int len = arr.length;
        int left = 0, right = len - 1; 

        while (left < right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                ++left;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[right])) {
                --right;
                continue;
            }
            if (arr[left] != arr[right]) {
                return false;
            }
            ++left; 
            --right;
        }
        return true;
    }
}
