package Leetcode.Tree;

public class Unique_BSTs_96 {

    /**
     * LeetCode solution, bottom-up
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] numOfTrees = new int[n+1];
        numOfTrees[0] = 1;
        numOfTrees[1] = 1;

        for (int N = 2; N <= n; N++) {
            for (int rootIndex = 1; rootIndex <= N; rootIndex++) {
                numOfTrees[N] += numOfTrees[rootIndex-1] * numOfTrees[N-rootIndex];
            }
        }
        return numOfTrees[n];
    }

    /**
     * LeetCode solution, top-down
     * @param n
     * @return
     */
    public int numTrees_lc(int n) {
        if (n == 0 || n == 1) return 1;

        int num = 0;
        for (int rootIndex = 1; rootIndex <= n; rootIndex++) {
            num += numTrees(rootIndex-1) * numTrees(n-rootIndex);
        }
        return num;
    }
}
