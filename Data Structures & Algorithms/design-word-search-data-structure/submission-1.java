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
        for (char c: word.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }
    }

    public void add(String word) {
        var curr = root;
        for (char c: word.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }
        curr.word = Optional.of(word);
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }
    public boolean dfs(char[] word, int index, Node node) {
        if (index >= word.length) {
            return node.isWord();
        }
        char c = word[index];
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
