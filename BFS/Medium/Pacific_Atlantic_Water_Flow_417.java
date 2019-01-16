package Leetcode.BFS.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pacific_Atlantic_Water_Flow_417 {

    public int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            Dfs(matrix, pacific, i, 0, matrix[i][0]);
            Dfs(matrix, atlantic, i, matrix[0].length-1, matrix[i][matrix[0].length-1]);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            Dfs(matrix, pacific, 0, j, matrix[0][j]);
            Dfs(matrix, atlantic, matrix.length-1, j, matrix[matrix.length-1][j]);
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] == atlantic[i][j] && pacific[i][j] == 1) res.add(new int[]{i, j});
            }
        }
        return res;
    }

    public void Dfs(int[][] matrix, int[][] visited, int i, int j, int preHeight) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[0].length
                || visited[i][j]==1 || preHeight>matrix[i][j]) return;

        visited[i][j] = 1;
        for (int[] m : move) {
            Dfs(matrix, visited, i+m[0], j+m[1], matrix[i][j]);
        }
    }
}
