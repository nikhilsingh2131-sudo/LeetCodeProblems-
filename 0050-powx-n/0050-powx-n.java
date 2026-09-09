class Solution {
    public double myPow(double x, int n) {
        return solve(x, (long)n);
    }

    public double solve(double x, long n) {

        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Negative power
        if (n < 0) {
            return solve(1 / x, -n);
        }

        // Even power
        if (n % 2 == 0) {
            return solve(x * x, n / 2);
        }

        // Odd power
        return x * solve(x * x, (n - 1) / 2);
    }
}