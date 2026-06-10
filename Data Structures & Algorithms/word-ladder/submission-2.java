class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- > 0) { 
                var curr = queue.poll().toCharArray();
                if (new String(curr).equals(endWord)) {
                    return count;
                }
                for (int i = 0; i < curr.length; ++i) {
                    char backup = curr[i];
                    for (char a = 'a'; a <= 'z'; ++a) {
                        if (backup == a) {
                            continue;
                        }
                        curr[i] = a;
                        String c = new String(curr);
                        if (wordSet.contains(c)) {
                            queue.offer(c);
                            wordSet.remove(c);
                        }
                    }
                    curr[i] = backup;
                }
            }
        }
        return 0;
    }
}
