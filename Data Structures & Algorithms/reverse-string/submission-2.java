class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char temp;
        temp = s[l];
        s[l++] = s[r];
        s[r--] = temp;
        while (l < r) {
            temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}