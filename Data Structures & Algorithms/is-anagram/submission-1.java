class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char c: sArr){
            freq[c - 'a']++;
        }
        for (char c: tArr){
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0){
                return false;
            }
        }
        for (int i: freq){
            if (i != 0 ) {
                return false;
            }
        }
        return true;
    }
}
