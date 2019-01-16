package Leetcode.BFS.Medium;

public class Surrounded_Regions_130 {

    /**
     * My Dfs solution. Start from the boarder 'O', do DFS and mark all adjacent 'O's as '*' to indicate that
     * those 'O' are not surrounded by 'X'
     *
     * @param board
     */
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        // For boarder 'O's, do DFS and mark adjacent 'O' as '*'
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') Dfs(row, 0, board);
            if (board[row][board[0].length-1] == 'O') Dfs(row, board[0].length-1, board);
        }
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') Dfs(0, col, board);
            if (board[board.length-1][col] == 'O') Dfs(board.length-1, col, board);
        }

        // For all remaining 'O', flip them to 'X', since those 'O's are surrounded by 'X'
        // For all '*', change them back to 'O', since those 'O's are connected to boarder directly or indirectly
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == '*') board[row][col] = 'O';
            }
        }
    }

    public static void Dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (board[row][col] == 'X' || board[row][col] == '*') return;

        board[row][col] = '*';
        Dfs(row - 1, col, board);
        Dfs(row + 1, col, board);
        Dfs(row, col - 1, board);
        Dfs(row, col + 1, board);
    }
}
