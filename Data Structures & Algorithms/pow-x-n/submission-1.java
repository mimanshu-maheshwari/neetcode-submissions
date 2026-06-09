class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        double val = helper(x, Math.abs(n));
        return n < 0 ? 1 / val : val;
    }
    private double helper(double x, int n) {
        if (n == 0){
            return 1;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }
}
