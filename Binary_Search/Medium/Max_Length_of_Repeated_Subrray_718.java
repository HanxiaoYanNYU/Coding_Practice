package Leetcode.Binary_Search.Medium;

public class Max_Length_of_Repeated_Subrray_718 {

    /**
     * Leetcode solution, DP
     * Use a 2D array "memo[i][j]" to store the Longest length of common sub-array that end at A[i] and B[j]
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;

        int[][] memo = new int[A.length][B.length];

        int len = 0;
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                if (a == 0 || b == 0) {
                    if (A[a] == B[b]) memo[a][b] = 1;
                    else memo[a][b] = 0;
                }
                else {
                    if (A[a] == B[b]) memo[a][b] = memo[a-1][b-1] + 1;
                    else memo[a][b] = 0;
                }
                len = Math.max(len, memo[a][b]);
            }
        }

        return len;
    }
}
