class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> de = new HashSet<>();
        for (String s: deadends) {
            de.add(s);
        }
        String start = "0000";
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int count = 0;
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Processing: " + queue.peek());
            while (size-- > 0) {
                String curr = queue.poll();
                if (target.equals(curr)) {
                    return count;
                }
                if (de.contains(curr) || seen.contains(curr)) {
                    continue;
                }
                seen.add(curr);
                char[] cc = curr.toCharArray();
                for (int i = 0; i < 4; ++i){
                    // original value
                    int change = cc[i] - '0';
                    
                    // increment
                    int inc = (change + 1) % 10;
                    cc[i] = (char) (inc + '0');
                    queue.offer(new String(cc));

                    // decrement 
                    int dec = (change - 1 + 10) % 10;
                    cc[i] = (char)(dec + '0');
                    queue.offer(new String(cc));

                    // reset
                    cc[i] = (char) (change + '0');
                }
            }
            ++count;
        }
        return -1;
    }
}