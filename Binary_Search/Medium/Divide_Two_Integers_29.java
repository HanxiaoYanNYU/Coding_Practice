package Leetcode.Binary_Search.Medium;

public class Divide_Two_Integers_29 {

    /**
     * Leetcode Solution
     *
     * Use long to calculate (long: 64bits; int: 32bits). Instead of times the divisor by 1,2,3, ... add 1 each time
     * We times the divisor by 1(2^0),2(2^1),4(2^2) each time before the product is greater than divident.
     *
     * Like TCP/IP retransmission.
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be 0.");
        long res = divideLong(dividend, divisor);
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }

    private static long divideLong(long divident, long divisor) {
        boolean positive = divident > 0 == divisor > 0;
        if (divident < 0) divident = -divident;
        if (divisor < 0) divisor = -divisor;

        if (divident < divisor) return 0;

        long divide = 1;
        long product = divisor;
        while ((product + product) <= divident) {
            product += product;
            divide += divide;
        }
        return positive ? divide + divideLong(divident-product, divisor) :
                -(divide + divideLong(divident-product, divisor));
    }
}
