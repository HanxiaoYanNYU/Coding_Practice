package Leetcode.Binary_Search.Medium;

public class Search_2D_Matrix_II_240 {

    /**
     * Binary search, reduce one row or one col each time
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0; int j = col - 1;
        while (i<row && j>=0) {
            int value = matrix[i][j];
            if (value == target) return true;
            else if (value < target) i++;
            else j--;
        }

        return false;
    }
}
