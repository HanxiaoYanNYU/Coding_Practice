package Leetcode.BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {

    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;

        // This queue name is useful for me to understand the solution
        Queue<int[]> neighborsShouldBeUpdated = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != 0) matrix[row][col] = Integer.MAX_VALUE;
                else neighborsShouldBeUpdated.add(new int[]{row, col});
            }
        }

        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!neighborsShouldBeUpdated.isEmpty()) {
            int[] center = neighborsShouldBeUpdated.poll();
            int centerRow = center[0];
            int centerCol = center[1];

            for (int[] m : move) {
                int rowChange = m[0];
                int colChange = m[1];
                int newRow = centerRow + rowChange;
                int newCol = centerCol + colChange;

                // Out of the bound
                if (newRow<0 || newRow>=matrix.length || newCol<0 || newCol>=matrix[0].length) continue;
                // The cell at [newRow, newCol] is closer to 0. So we don't update its value, thus we don't
                // update its neighbors too. That's the reason we do not add it to neighborsShouldBeUpdated queue
                if (matrix[newRow][newCol] <= matrix[centerRow][centerCol] + 1) continue;

                matrix[newRow][newCol] = matrix[centerRow][centerCol] + 1;
                // Since we update value at [newRol, newCol], its neighbors should be updated too
                neighborsShouldBeUpdated.add(new int[]{newRow, newCol});
            }
        }
        return matrix;
    }
}
