package Leetcode.Google.Onsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Robot_Move {

    /*
        给定一个矩形的宽和长，求所有可能的路径数量

        Rules：
        1. 从左上角走到右上角
        2. 要求每一步只能向正右、右上或右下走，即 →↗↘

        followup1: 优化空间复杂度至 O(n)
        followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路经
        followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数量
        followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有路径数量 (x >= H)
        followup5: 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量
     */

    public static int uniquePath(int row, int col) {
        if (row == 0 && col == 0 || row >= 1 && col == 1) return 0;
        if (row <= 2) return 1;

        int[][] grid = new int[row][col];

        // initial base case for col1 and col2
        grid[0][1] = 1;
        grid[1][1] = 1;

        // bottom up build
        for (int c = 2; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (r == 0) {
                    grid[r][c] = grid[r][c-1] + grid[r+1][c-1];
                } else if (r == row - 1) {
                    grid[r][c] = grid[r][c-1] + grid[r-1][c-1];
                } else {
                    grid[r][c] = grid[r][c-1] + grid[r-1][c-1] + grid[r+1][c-1];
                }
            }
        }

        return grid[0][col-1];
    }

    public static int uniquePath_followup1(int row, int col) {
        if (row == 0) return 0;
        if (row >= 1 && col == 1) return 1;

        // Only record the previous column and curr column
        int[] prev = new int[row];
        int[] curr = new int[row];

        // initial base case for prev
        prev[0] = 1;

        // bottom up build
        for (int c = 1; c < col; c++) {
            for (int r = 0; r < row; r++) {
                int topLeft = (r - 1 >= 0) ? prev[r-1] : 0;
                int left = prev[r];
                int bottomLeft = (r + 1 < row) ? prev[r + 1] : 0;

                curr[r] = topLeft + left + bottomLeft;
            }
            // copy value from curr to prev
            for (int i = 0; i < row; i++) prev[i] = curr[i];
        }

        return prev[0];
    }

    /* follow up 2 */
    public static boolean hasPath(int row, int col, int[][] nodes) {
        // nodes is a 3 rows 2 cols 2d array, assume nodes are sorted on column from small to large
        if (row == 0 || col < nodes.length) return false;

        int preCol = -1;
        for (int[] node : nodes) {
            if (node[1] <= preCol) return false;
            preCol = node[1];
        }

        int column = 0;
        int upper = 0;
        int lower = 0;

        for (int[] node : nodes) {
            while (column < node[1]) {
                upper = upper == 0 ? 0 : upper - 1;
                lower = lower == row - 1 ? row - 1 : lower + 1;
                column++;
            }
            if (node[0] < upper || node[0] > lower) return false;
            upper = node[0];
            lower = node[0];
        }

        return 0 >= upper;
    }

    public static int pathCount(int row, int col, int[][] nodes) {
        List<int[]> list = new ArrayList<>();
        int preCol = -1;
        for (int[] node : nodes) {
            if (node[1] <= preCol) return 0;
            list.add(node);
            preCol = node[1];
        }
        list.add(new int[]{0, col-1});

        // sort nodes on their column
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // initialize base case
        int[] pre = new int[row];
        int[] curr = new int[row];
        pre[0] = 1;

        int column = 0;
        for (int[] node : list) {
            while (column < node[1]) {
                for (int r = 0; r < row; r++) {
                    int topLeft = r >= 1 ? pre[r-1] : 0;
                    int left = pre[r];
                    int bottomLeft = (r + 1 < row) ? pre[r+1] : 0;
                    curr[r] = topLeft + left + bottomLeft;
                }
                for (int i = 0; i < row; i++) pre[i] = curr[i];
                column++;
            }

            if (pre[node[0]] == 0) return 0; //if pre[x] is 0, it means that there is no path from [0,0] to node
            for (int i = 0; i < row; i++) {
                if (i != node[0]) pre[i] = 0; // clear other cells path number, since [0,0] should only reach node
                                              // on this column
            }
        }

        return pre[0];
    }
}
