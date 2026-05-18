class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> de = new HashSet<>();
        for (String s: deadends) {
            de.add(s);
        }
        String start = "0000";
        Deque<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.offer(start);
        seen.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Processing: " + queue.peek());
            while (size-- > 0) {
                String curr = queue.poll();
                if (target.equals(curr)) {
                    return count;
                }
                if (de.contains(curr)) {
                    continue;
                }
                for (int i = 0; i < 4; ++i){
                    for (int k : new int[]{-1, 1}){
                        char[] cc = curr.toCharArray();
                        // change value
                        cc[i] = (char) (((cc[i] - '0' + k + 10) % 10) + '0');
                        String next = new String(cc);
                        if (seen.contains(next)) {
                            continue;
                        }
                        queue.offer(next);
                        seen.add(next);
                    }
                }
            }
            ++count;
        }
        return -1;
    }
}