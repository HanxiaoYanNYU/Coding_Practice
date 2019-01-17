package Leetcode.DFS.Medium;

public class Max_Area_of_Island_695 {

    int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, calculateArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int calculateArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int area = 1;
        for (int[] m : move) {
            area += calculateArea(grid, i + m[0], j + m[1]);
        }
        return area;
    }
}
