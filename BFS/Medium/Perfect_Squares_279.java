package Leetcode.BFS.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Perfect_Squares_279 {

    /**
     * My solution, Time Limit Exceed
     * This solution works, but it takes long time to proceed.
     *
     * @param n
     * @return
     */
    public static int numSquares_TLE(int n) {
        if (n == 0) return 0;
        //The following 2 lines for code is REDUNDANT
        //int sqrt = (int)(Math.sqrt(n) / 1); // if n=5, then this sqrt is 2
        //if (sqrt * sqrt == n) return 1; // This two lines of code checks whether n itself is a square number (e.g. 16, 9, 64...)

        int i = 1;
        int num = Integer.MAX_VALUE;
        while (i*i <= n) {
            num = Math.min(num, 1 + numSquares_TLE(n - i*i));
            i++;
        }
        return num;
    }

    /**
     * My DP solution, finally AC, beats 52.97%, 39ms
     * Top down solution
     *
     * @param n
     * @return
     */
    public static int numSquares_DP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        int res = findNumSquares(n, dp);
        return res;
    }

    public static int findNumSquares(int n, int[] dp) {
        int i = 1;
        int num = Integer.MAX_VALUE;
        while (i*i <= n) {
            num = Math.min(num, 1 + (dp[n-i*i] == -1 ? findNumSquares(n-i*i, dp) : dp[n-i*i]));
            i++;
        }
        dp[n] = num;

        return num;
    }

    /**
     * Leetcode DP solution updated by me, beats 63.35%, 34ms
     * Bottom up solution
     *
     * @param n
     * @return
     */
    public static int numSquares_lc_updated(int n) {
        int[] square = new int[n + 1]; // each element is 0

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (j*j <= i) {
                min = Math.min(min, 1 + square[i-j*j]);
                j++;
            }
            square[i] = min;
        }
        return square[n];
    }
}
