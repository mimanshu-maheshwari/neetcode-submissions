class Solution {
    // a -> after chars
    // a comes before these after chars
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visiting;
    List<Character> result;
    public String foreignDictionary(String[] words) {

        // variables setup
        int n = words.length;
        adj = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // adjecancy list
        for (int i = 1; i < n; ++i) {
            String prevWord = words[i - 1];
            String currWord = words[i];
            int len = Math.min(prevWord.length(), currWord.length());
            if (prevWord.length() > currWord.length() &&
             prevWord.substring(0, len).equals(currWord.substring(0, len))) {
                return "";
            }
            for (int j = 0; j < len; ++j) {
                if (prevWord.charAt(j) != currWord.charAt(j)) {
                    adj.get(prevWord.charAt(j)).add(currWord.charAt(j));
                    break;
                }
            }
        }

        visiting = new HashMap<>();
        result = new ArrayList<>();
        for (char c: adj.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        return result.stream().reduce("", (a, b) -> b + a, String::concat);
        
    }

    boolean dfs(char node) {
        if (visiting.containsKey(node)) {
            return visiting.get(node);
        }

        visiting.put(node, true);
        for (char next : adj.get(node)) {
            if (dfs(next)) {
                return true;
            }
        }
        visiting.put(node, false);
        result.add(node);
        return false;
    }
}
