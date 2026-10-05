class TrieNode {
    HashMap<Character, TrieNode> children;
    Optional<String> word;

    public TrieNode() {
        children = new HashMap<>();
        word = Optional.empty();
    }

    public boolean isWord() {
        return word.isPresent();
    }

    public boolean isCharPresent(char c) {
        return children.get(c) != null;
    }
}

class Trie {
    TrieNode root;

    public Trie(String[] words) {
        this.root = new TrieNode();
        for (String word: words) {
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = Optional.of(word);
        }
    }
}
class Solution {
    TrieNode trie;
    public int minExtraChar(String s, String[] dictionary) {
        // memo based on index and result;
        var memo = new HashMap<Integer, Integer>();
        trie = new Trie(dictionary).root;
        memo.put(s.length(), 0);
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int index, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // if we skip the char
        int result = 1 + dfs(s, index + 1, memo);

        var curr = trie;

        for (int i = index; i < s.length(); ++i) {
            if (!curr.isCharPresent(s.charAt(i))) {
                break;
            }
            curr = curr.children.get(s.charAt(i));
            if (curr.isWord()) {
                result = Math.min(result, dfs(s, i + 1, memo));
            }
        }
        
        memo.put(index, result);
        return result;
    }
}