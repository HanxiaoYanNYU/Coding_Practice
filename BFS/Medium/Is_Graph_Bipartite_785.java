package Leetcode.BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite_785 {

    /**
     * My BFS solution
     *
     * Iterate all nodes, for each node color the whole connected graph which contain it using bfs
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int[] nodeColor = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (nodeColor[i] != 0) continue;
            if (!isValidGraph(i, nodeColor, graph)) return false;
        }
        return true;
    }

    public boolean isValidGraph(int currNode, int[] nodeColor, int[][] graph) {
        if (graph[currNode].length == 0) return true;

        nodeColor[currNode] = 1;
        Queue<Integer> nodesColored = new LinkedList<>();
        nodesColored.add(currNode);

        while (!nodesColored.isEmpty()) {
            int curr = nodesColored.poll();
            for (int neighbor : graph[curr]) {
                if (nodeColor[neighbor] == 0) {
                    nodeColor[neighbor] = nodeColor[curr] == 1 ? -1 : 1;
                    nodesColored.add(neighbor);
                } else {
                    if (nodeColor[curr] == nodeColor[neighbor]) return false;
                }
            }
        }

        return true;
    }

    /**
     * DFS solution
     *
     * @return
     */
    public boolean isBipartite_dfs(int[][] graph) {
        int[] nodeColor = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (nodeColor[i] != 0) continue;
            if (!isValid(i, 1, nodeColor, graph)) return false;
        }
        return true;
    }

    public boolean isValid(int node, int color, int[] nodeColor, int[][] graph) {
        if (nodeColor[node] == 0) {
            nodeColor[node] = color;
            int newColor = color == 1 ? -1 : 1;
            for (int neighbor : graph[node]) {
                if (!isValid(neighbor, newColor, nodeColor, graph)) return false;
            }
            return true;
        } else {
            return nodeColor[node] == color;
        }
    }
}
