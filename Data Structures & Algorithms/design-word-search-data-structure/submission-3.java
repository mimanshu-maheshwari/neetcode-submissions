class Node {
    Optional<String> word;
    Node[] children;

    public Node(){
        word = Optional.empty();
        children = new Node[26];
    }
    public boolean isWord() {
        return word.isPresent();
    }
}
class Trie {
    Node root;

    public Trie(){
        root = new Node();
    }

    public void add(String word) {
        var curr = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = Optional.of(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, Node node) {
        if (index >= word.length()) {
            return node.isWord();
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node n: node.children) {
                if (n != null && dfs(word, index + 1, n)) {
                    return true;
                }
            }
            return false;
        } else {
            var next = node.children[c - 'a'];
            if (next == null) {
                return false;
            }
            return dfs(word, index + 1, next);
        }
    }
}
class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
