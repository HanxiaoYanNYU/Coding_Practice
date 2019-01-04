package Leetcode.Binary_Search.Medium;

public class Pow_50 {

    /**
     * Recursive solution, O(logn)
     * Be aware of the limit of int [-2^31, 2^31 - 1], the max positive number is smaller least number than 1
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        //if (n == 1) return x; // This line of code can be removed. Since if n=1,
                              // it will goes to "return x * myPow(x*x, n/2)", and since n/2 is 0,
                              // x * myPow(x*x, n/2) => x * 1

        if (n < 0) return (1/x) * myPow(1/x, -n-1);
        else if (n % 2 == 0) return myPow(x*x, n/2);
        else return x * myPow(x*x, n/2);
    }
}
