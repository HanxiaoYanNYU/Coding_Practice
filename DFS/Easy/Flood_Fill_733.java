package Leetcode.DFS.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill_733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] pixel = q.poll();

            for (int[] m : move) {
                int row = pixel[0] + m[0];
                int col = pixel[1] + m[1];
                if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) continue;
                if (image[row][col] != oldColor) continue;
                image[row][col] = newColor;
                q.add(new int[]{row, col});
            }
        }

        return image;
    }
}
