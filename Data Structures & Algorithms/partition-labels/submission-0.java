class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        if (len <= 1) {
            return Arrays.asList(len);
        }
        // store last occurence of string;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(str[i], i);
        }
        var result = new ArrayList<Integer>();
        int start = 0;
        int maxLen = -1;
        for (int i = 0; i < len; ++i) {
            maxLen = Math.max(map.get(str[i]), maxLen);
            if (i == maxLen) {
                result.add(maxLen - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
