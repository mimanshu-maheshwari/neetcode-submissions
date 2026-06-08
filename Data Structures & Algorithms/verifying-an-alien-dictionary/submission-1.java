class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 0){
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; ++i) {
            char[] wa = words[i - 1].toCharArray();
            char[] wb = words[i].toCharArray();
            for (int j = 0; j < Math.max(wa.length, wb.length); ++j) {
                if (j >= wa.length){ 
                    break;
                }
                if (j >= wb.length || map.get(wa[j]) > map.get(wb[j])) {
                    return false;
                } else if (map.get(wa[j]) < map.get(wb[j])) {
                    break;
                }
            }
        }

        return true;
    }
}