package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    private int[] col;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        col = new int[n]; // Use 1D array to check if current place has a queen,
                          // The value of each cell is the index of row. E.g. if col[0] = 3, it means there is
                          // queen at row = 3, col = 0;
        for (int i = 0; i < n; i++) { col[i]=-1; } // init array as -1s to indicate there is no queen placed here
        List<List<Integer>> queens = new ArrayList<>();
        putQueens(queens, new ArrayList<>(), 0, n);
        generateBoard(res, queens);
        return res;
    }

    private void putQueens(List<List<Integer>> queens, List<Integer> track, int queensOnBoard, int n) {
        if (queensOnBoard == n) {
            queens.add(new ArrayList<>(track));
            return;
        }

        int currR = queensOnBoard;
        for (int c = 0; c < n; c++) {
            int currC = c;
            if (track.size() == 0 || canPut(currR, currC, n)) {
                col[currC] = currR; track.add(currC);
                putQueens(queens, track, queensOnBoard+1, n);
                col[currC] = -1; track.remove(track.size()-1);
            }
        }
    }

    private boolean canPut(int R, int C, int n) {
        if (col[C] != -1) return false; // Have another queen on col C
        for (int c = 0; c < n; c++) {
            int r = col[c];
            if (r == -1) continue;
            if (c-r == C-R) return false; // check topLeft-bottomRight diagonal
            if (c+r == C+R) return false; // check bottomLeft-topRight diagonal
        }
        return true;
    }

    private void generateBoard(List<List<String>> res, List<List<Integer>> queens) {
        for (List<Integer> list : queens) {
            List<String> r = new ArrayList<>();
            for (Integer l : list) {
                char[] boardRow = new char[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    if (i == l) boardRow[i] = 'Q';
                    else boardRow[i] = '.';
                }
                r.add(new String(boardRow));
            }
            res.add(r);
        }
    }

    public static void main(String[] args) {
        N_Queens queens = new N_Queens();
        List<List<String>> res = queens.solveNQueens(4);
        System.out.println(res);
    }
}
