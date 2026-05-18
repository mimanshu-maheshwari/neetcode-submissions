class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visiting; 
    private List<Character> result;

    public String foreignDictionary(String[] words) {
      adj = new HashMap<>();
      visiting = new HashMap<>();
      result = new ArrayList<>();

      // create adjacency list;
      for (String word: words) {
        for (char c: word.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
        }
      }

      for (int i = 1; i < words.length; ++i) {
        String w1 = words[i - 1];
        String w2 = words[i];
        int len = Math.min(w1.length(), w2.length());
        if (w1.length() > w2.length() && 
            w1.substring(0, len).equals(w2.substring(0, len))
        ) {
            return "";
        }
        for (int j = 0; j < len; ++j) {
            if (w1.charAt(j) != w2.charAt(j)) {
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }

      for (char c: adj.keySet()) {
        if (dfs(c)) {
            return "";
        }
      }

      return result.stream().reduce("", (a,b) -> b + a, String::concat);
    }

    private boolean dfs(char node) {
        if (visiting.containsKey(node)) {
            // will always be true
            return visiting.get(node);
        }

        visiting.put(node, true);
        for (char next: adj.get(node)) {
            if (dfs(next)) {
                return true;
            }
        }
        visiting.put(node, false);
        result.add(node);
        return false;
    }
}
