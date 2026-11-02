class Solution {
    public String minWindow(String s, String t) {
        // prep step 
        var string = s.toCharArray();
        var tMap = new HashMap<Character, Integer>();
        for (char ts: t.toCharArray()) {
            tMap.merge(ts, 1, Integer::sum);
        }
        
        int need = tMap.size(), 
            have = 0;

        int left = 0;
        int start = -1, end = -1;
        int resultLen = Integer.MAX_VALUE;
        var sMap = new HashMap<Character, Integer>();
        for (int right = 0; right < string.length; ++right) {
            char r = string[right];
            sMap.merge(r, 1, Integer::sum);
            if (tMap.containsKey(r) && sMap.get(r).equals(tMap.get(r))) {
                ++have;
            }
            while (have == need) {
                if (resultLen > right - left + 1){
                    start = left;
                    end = right;
                    resultLen = right - left + 1;
                }
                char l = string[left];
                sMap.merge(l, -1, Integer::sum);
                if (tMap.containsKey(l) && sMap.get(l) < tMap.get(l)){
                    --have;
                }
                ++left;
            }
        }
        return resultLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}
