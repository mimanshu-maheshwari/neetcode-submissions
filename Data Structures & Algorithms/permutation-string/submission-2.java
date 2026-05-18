class Solution {
    public boolean checkInclusion(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l1 = s1.length, l2 = s2.length;

        if (l1 > l2) {
            return false;
        }

        int[] s1Map = new int[26], 
              s2Map = new int[26];

        for (int i = 0; i < l1; ++i ) {
            s1Map[s1[i] - 'a']++;
            s2Map[s2[i] - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; ++i) {
            if (s1Map[i] == s2Map[i]) {
                ++matches;
            }
        }

        int l = 0;
        for (int r = l1; r < l2; ++r) {
            if (matches == 26) {
                return true;
            }
            s2Map[s2[r] - 'a']++;
            if (s2Map[s2[r] - 'a'] == s1Map[s2[r] - 'a']) {
                matches++;
            } else if (s2Map[s2[r] - 'a'] == s1Map[s2[r] - 'a'] + 1) {
                matches--;
            }

            s2Map[s2[l] - 'a']--;
            if (s2Map[s2[l] - 'a'] == s1Map[s2[l] - 'a']) {
                matches++;
            } else if (s2Map[s2[l] - 'a'] == s1Map[s2[l] - 'a'] - 1) {
                matches--;
            }
            ++l;
        }
        return matches == 26;
    }
}
