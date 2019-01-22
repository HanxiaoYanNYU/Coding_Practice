package Leetcode.DFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Friend_Circles_547 {

    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        boolean[] visited = new boolean[M.length];
        int circles = 0;
        for (int self = 0; self < M.length; self++) {
            if (visited[self]) continue;
            else {
                circles++;
                findFriends(self, M, visited);
            }

        }
        return circles;
    }

    public static void findFriends(int self, int[][] M, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(self);
        visited[self] = true;

        while (!q.isEmpty()) {
            int me = q.poll();
            for (int friend = 0; friend < M.length; friend++) {
                if (me == friend || M[me][friend] == 0 || visited[friend]) continue;
                q.add(friend);
                visited[friend] = true;
            }
        }
    }

    /**
     * Union find solution, WITHOUT path compression
     *
     * YouTube link: https://www.youtube.com/watch?v=0jNmHPfA_yE
     *
     * Find operation: To find which component a particular element belongs to, find the root of that component
     * by following the parent nodes until a self loop is reached (a node whose parent is itself)
     *
     * Union operation: if root nodes of two elements are different, make one of the root node be the parent of the
     * other
     *
     * @param M
     * @return
     */
    public int findCircleNum_unionFind(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int[] rootOfNode = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            rootOfNode[i] = i;
        }

        int circles = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    int rootOfI = findRoot(i, rootOfNode);
                    int rootOfJ = findRoot(j, rootOfNode);
                    if (rootOfI != rootOfJ) {
                        rootOfNode[rootOfJ] = rootOfI; // Union operation: connect one root to another root
                        circles--;
                    }
                }
            }
        }
        return circles;
    }

    public int findRoot(int i, int[] rootOfNode) {
        while (rootOfNode[i] != i) { // Find one node's root node
            i = rootOfNode[i];
        }
        return i;
    }
}
