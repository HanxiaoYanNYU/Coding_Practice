package Leetcode.Binary_Search.Easy;

public class Arrangin_Coins_441 {

    /***
     * O(n)
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        if (n <= 0) return -1;
        int i = 1;

        while (n > 0) {
            if (n == i) return i;
            if (n < i) return i - 1;
            n = n - i;
            i++;
        }
        return -1;
    }

    /***
     * Binary search, O(logn)
     * use Long type to prevent integer overflow
     *
     * @param n
     * @return
     */
    public static int arrangeCoins_2(int n) {
        if (n <= 0) return 0;

        long left = 1;
        long right = n;

        while (left <= right) {
            long middle = left + (right - left) / 2;
            long sum = (1 + middle) * middle / 2;

            if (sum == n) return (int)middle;
            else if (sum < n) left = middle + 1;
            else right = middle - 1;
        }
        return (int)left - 1;
    }
}
