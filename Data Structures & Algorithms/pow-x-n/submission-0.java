class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = 1;
        if (n < 0){
            while (n != 0){
                result *= 1.0 / x;
                n++;
            }
        } else {
            while (n != 0){
                result *= x;
                n--;
            }
        }
        return result;
    }
}
