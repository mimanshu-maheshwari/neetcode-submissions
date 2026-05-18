class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        char[] cs1 = s1.toCharArray();
        Arrays.sort(cs1);
        for (int i = 0; i < s2Len - s1Len + 1; ++i) {
            if (isAnagram(cs1, s2.substring(i, i + s1Len))) {
                return true;
            }
        }
        return false;
    }
    public boolean isAnagram(char[] cs1, String s2) {
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs2);
        for (int i = 0; i < cs1.length; ++i){
            if (cs1[i] != cs2[i]) {
                return false;
            }
        }
        return true;
    }
}
