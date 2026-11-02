class Trie {
    class Node {
        private Node[] children;
        private Optional<String> word;
        public Node() {
            children = new Node[26];
            word = Optional.empty();
        }
        public boolean isWord(){
            return word.isPresent();
        }
    }

    private Node root;

    public Trie(String word) {
        root = new Node();
        Node curr = root;
        for (int i = 0; i < word.length(); ++i) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new Node();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.word = Optional.of(word);
    }

    public Trie(List<String> wordDict) {
        root = new Node();
        for (String word: wordDict) {
            Node curr = root;
            for (int i = 0; i < word.length(); ++i) {
                if (curr.children[word.charAt(i) - 'a'] == null) {
                    curr.children[word.charAt(i) - 'a'] = new Node();
                }
                curr = curr.children[word.charAt(i) - 'a'];
            }
            curr.word = Optional.of(word);
        }
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); ++i) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return true;
    }

    public boolean contains(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); ++i) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr.isWord();
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie(wordDict);
        var list = new ArrayList<String>();
        dfs(s, trie, 0, new ArrayList<>(), new StringBuilder(), list);
        return list;
    }

    private void dfs(String s, Trie trie, int index, List<String> stringList, StringBuilder currString, List<String> result) {
        if (index == s.length()) {
            if (currString.isEmpty()) {
                result.add(String.join(" ", stringList));
            }
            return;
        }
        // add 
        currString.append(s.charAt(index));
        if (trie.contains(currString.toString())) {
            stringList.add(currString.toString());
            dfs(s, trie, index + 1, stringList, new StringBuilder(), result);
            stringList.remove(stringList.size() - 1);
        }
        if (trie.startsWith(currString.toString())) {
            dfs(s, trie, index + 1, stringList, currString, result);
        }
    }
}