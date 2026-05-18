class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n) && n != 1) {
            set.add(n);
            n = sumSquare(n);
        }
        return n == 1;
    }
    private int sumSquare(int n) {
        int result = 0;
        while (n > 0){
            int rem = n % 10;
            result += rem * rem;
            n /= 10;
        }
        return result;
    }
}
