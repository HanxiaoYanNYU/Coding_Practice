package Leetcode.BFS.Medium;

public class Number_of_Islands_200 {

    /**
     * My solution. Every time we find a 1, make numOfIslands plus 1, and then convert all of 1s of this island
     * to 0s
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    clearIsland(row, col, grid);
                }
            }
        }
        return islands;
    }

    // Dfs to find this island
    public static void clearIsland(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        clearIsland(row-1, col, grid);
        clearIsland(row, col+1, grid);
        clearIsland(row+1, col, grid);
        clearIsland(row, col-1, grid);
    }
}

