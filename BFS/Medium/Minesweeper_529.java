package Leetcode.BFS.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minesweeper_529 {

    public static int[][] move = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            int mines = findAdjacentMines(i, j, board);
            if (mines != 0) {
                board[i][j] = (char)(mines + '0');
            } else {
                revealBoard(i, j, board);
            }
        }
        return board;
    }

    public static int findAdjacentMines(int i, int j, char[][] board) {
        int mines = 0;
        for (int[] m : move) {
            if (isInBoundary(i + m[0], j + m[1], board)) {
                mines = board[i+m[0]][j+m[1]] == 'M' ? mines + 1 : mines;
            }
        }
        return mines;
    }

    public static boolean isInBoundary(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void revealBoard(int i, int j, char[][] board) {
        Queue<int[]> readyToReveal = new LinkedList<>();
        readyToReveal.add(new int[]{i, j});
        int[][] visited = new int[board.length][board[0].length];
        visited[i][j] = 1;

        while (!readyToReveal.isEmpty()) {
            int[] cord = readyToReveal.poll();
            int row = cord[0];
            int col = cord[1];

            int mines = findAdjacentMines(row, col, board);
            if (mines != 0) {
                board[row][col] = (char)(mines + '0');
            } else {
                board[row][col] = 'B';
                for (int[] m : move) {
                    int r = row + m[0];
                    int c = col + m[1];
                    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]==1
                            || board[r][c] != 'E') continue;
                    readyToReveal.add(new int[]{r, c});
                    visited[r][c] = 1;
                }
            }
        }
    }
}
