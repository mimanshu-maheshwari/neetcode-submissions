class Node {
    Optional<String> word;
    HashMap<Character, Node> children;

    public Node(){
        word = Optional.empty();
        children = new HashMap<>();
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
    public Trie(String word){
        root = new Node();
        var curr = root;
        for (int i = 0; i < word.length(); ++i) {
            curr.children.putIfAbsent(word.charAt(i), new Node());
            curr = curr.children.get(word.charAt(i));
        }
    }

    public void add(String word) {
        var curr = root;
        for (int i = 0; i < word.length(); ++i) {
            curr.children.putIfAbsent(word.charAt(i), new Node());
            curr = curr.children.get(word.charAt(i));
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
            for (Node n: node.children.values()) {
                if (dfs(word, index + 1, n)) {
                    return true;
                }
            }
            return false;
        } else {
            var next = node.children.get(c);
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
