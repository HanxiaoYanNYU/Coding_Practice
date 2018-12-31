package Leetcode.Binary_Search.Medium;

public class Search_a_2D_Matrix_74 {

    /**
     * My solution
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) bottom = mid - 1;
            else if (matrix[mid][0] < target && target <= matrix[mid][matrix[0].length-1]) {
                top = mid;
                break;
            }
            else top = mid + 1;
        }

        if (matrix[top][0] <= target && target <= matrix[top][matrix[0].length-1]) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[top][mid] == target) return true;
                else if (matrix[top][mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Leetcode solution
     * Think of matrix as an array and use quotient and remainder to implement
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean search(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = matrix[mid/col][mid%col];
            if (num == target) return true;
            else if (num < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
