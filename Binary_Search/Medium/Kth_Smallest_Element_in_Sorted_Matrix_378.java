package Leetcode.Binary_Search.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_Sorted_Matrix_378 {

    /**
     * Using Priority Queue, max heap stores exactly k numbers
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest_0(int[][] matrix, int k) {
        int n = matrix.length;

        if (k == 1) return matrix[0][0];
        if (k == n * n) return matrix[n-1][n-1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) return 0;
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() == k && matrix[i][j] < pq.peek()) {
                    pq.remove();
                    pq.add(matrix[i][j]);
                } else if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }

    /**
     * LeetCode solution, very smart!
     *
     * The key point of this solution is to remember there must be one number in range[left, right]
     * which is the kth smallest
     *
     * 最后的范围是 [13, 14], 也就是说 <=13的有8个数，<=14的也有8个数。那我们要选小的那个数字(这个数字在matrix中的位置8上)，也就是13.
     * 因为只有选择了13，才能既满足<=13的有8个数，又满足<=14的也有8个数。如果选择14，就不可能同时满足两个条件。
     * 而且也正是因为我们选择了13，也可以证明13是在matrix中的数字，而14不在matrix中
     *
     * 假如我们选择了14, [1,2,3,4,5,6,7,14,15,...]
     *                                ^
     *                                |
     *                               位置8
     * 那么13就不可能再在这个数组中排到位置8，只有反过来，选择13，那么<=14的数字才可能也有8个：比如：
     * [1,2,3,4,5,6,7,13,15,...]
     *                ^
     *                |
     *               位置8，同样如果把14放到这个数组里，<=14的还是有8个
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while (left < right) {
            int middle = left + (right - left) / 2;
            int count = 0; // the count of how many numbers in the whole matrix smaller than or equals to mid
            int col = n - 1;

            for (int row = 0; row < n; row++) {
                while (0 <= col && matrix[row][col] > middle) {
                    col--;
                }
                count = count + col + 1; // count how many numbers on row i is smaller or equals to mid
            }

            if (count < k) left = middle + 1;
            else if (count >= k) right = middle; // 当count>k的时候，middle这个数依然是备选答案，所以在这里令 right = middle
                                                 // 而不是 right = middle - 1。
                                                 // 原因是，如果第k个值是有重复值的话(e.g. [1, 2, 3, 13, 13], k = 4)
                                                 // 那么对于13来说，<=13的数字个数是5，而不是4。在这种情况下 count = 5 是
                                                 // 大于 k = 4的。然而 count = 5所对应的13，依然是我们的答案。所以令
                                                 // right = middle帮助我们保留了正确答案。
        }

        return right;
    }
}
