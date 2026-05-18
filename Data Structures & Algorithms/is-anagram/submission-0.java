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
        int sum = 0;
        for (int i: freq){
            sum += i;
        }
        return sum == 0;
    }
}
