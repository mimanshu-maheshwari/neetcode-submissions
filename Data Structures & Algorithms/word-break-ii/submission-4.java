class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.addWord(word);
        }

        Map<Integer, List<String>> cache = new HashMap<>();
        return backtrack(0, s, trie, cache);
    }

    private List<String> backtrack(int index, String s, Trie trie, Map<Integer, List<String>> cache) {
        if (index == s.length()) {
            return Collections.singletonList("");
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        List<String> res = new ArrayList<>();
        TrieNode curr = trie.root;

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!curr.children.containsKey(c)) {
                break;
            }
            curr = curr.children.get(c);
            if (curr.isWord) {
                for (String suffix : backtrack(i + 1, s, trie, cache)) {
                    if (!suffix.isEmpty()) {
                        res.add(s.substring(index, i + 1) + " " + suffix);
                    } else {
                        res.add(s.substring(index, i + 1));
                    }
                }
            }
        }

        cache.put(index, res);
        return res;
    }
}