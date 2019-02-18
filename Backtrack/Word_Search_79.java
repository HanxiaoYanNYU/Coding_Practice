package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Search_79 {

    private int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};

    /*
        My first solution use List to store the visited positions, but it runs very slow, beats only 12%
        I should use "boolean[][] visited" to check if this point is visited, we can beats 68% using this method
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;

        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0]) {
                    if (findPath(i, j, 0, board, w, new ArrayList<>())) return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(int i, int j, int wordPos, char[][] board, char[] w, List<String> track) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != w[wordPos] || track.contains(i + "," + j)) return false;
        if (wordPos == w.length - 1) return true;

        track.add(i + "," + j);
        for (int[] m : move) {
            if (findPath(i+m[0], j+m[1], wordPos+1, board, w, track)) return true;
        }
        track.remove(track.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Word_Search_79 m = new Word_Search_79();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean res = m.exist(board, "ABCESEEEFS");
        System.out.println(res);
    }
}
