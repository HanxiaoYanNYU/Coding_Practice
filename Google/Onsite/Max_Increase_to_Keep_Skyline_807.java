package Leetcode.Google.Onsite;

public class Max_Increase_to_Keep_Skyline_807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] topView = new int[rows];
        int[] leftView = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                leftView[i] = Math.max(leftView[i], grid[i][j]);
                topView[j] = Math.max(topView[j], grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += Math.abs(grid[i][j] - Math.min(topView[j], leftView[i]));
            }
        }
        return sum;
    }
}
