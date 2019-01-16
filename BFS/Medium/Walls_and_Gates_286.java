package Leetcode.BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Walls_and_Gates_286 {

    /**
     * My BFS solution. Remember BFS is a good method for shortest path problem.
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> updateNeighbor = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) updateNeighbor.add(new int[]{i, j});
            }
        }

        while (!updateNeighbor.isEmpty()) {
            int[] r = updateNeighbor.poll();
            for (int[] m : move) {
                int row = r[0] + m[0];
                int col = r[1] + m[1];
                if (row<0 || row>=rooms.length || col<0 || col>=rooms[0].length ||
                        rooms[row][col] <= rooms[r[0]][r[1]] + 1 || rooms[row][col]==-1) continue;
                rooms[row][col] = rooms[r[0]][r[1]] + 1;
                updateNeighbor.add(new int[]{row, col});
            }
        }
    }
}
