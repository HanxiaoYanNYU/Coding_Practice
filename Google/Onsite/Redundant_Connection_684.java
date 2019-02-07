package Leetcode.Google.Onsite;

import java.util.*;

public class Redundant_Connection_684 {

    /**
     * Youtube DFS solution
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] res = new int[]{-1, -1};

        for (int[] e : edges) {
            if (isPath(e[0], e[1], graph, new HashSet<>())) return e;

            if (!graph.containsKey(e[0])) graph.put(e[0], new ArrayList<>());
            if (!graph.containsKey(e[1])) graph.put(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return res;
    }

    public boolean isPath(int from, int to, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (from == to) return true;

        if (!graph.containsKey(from) || !graph.containsKey(to)) return false;
        visited.add(from);

        boolean findPath = false;
        for (Integer neighbor : graph.get(from)) {
            if(!visited.contains(neighbor)) {
                findPath = isPath(neighbor, to, graph, visited);
            }
            if (findPath) break;
        }
        return findPath;
    }

    /**
     * Youtube union find solution
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection_unionFind(int[][] edges) {
        int n = edges.length; // Since we have 1 more redundant edge in a tree, then edge number is nodes number
        int[] nodeRoot = new int[n + 1]; // Since node number start from 1, so we have dummy node 0;
        for (int i = 0; i < n; i++) {
            nodeRoot[i] = i;
        }

        for (int[] e : edges) {
            int node1 = e[0];
            int node2 = e[1];

            int root1 = findRoot(node1, nodeRoot);
            int root2 = findRoot(node2, nodeRoot);

            if (root1 == root2) return e;
            union(root1, root2, nodeRoot);
        }

        return new int[]{-1, -1};
    }

    private int findRoot(int node, int[] nodeRoot) {
        while (nodeRoot[node] != node) {
            node = nodeRoot[node];
        }
        return node;
    }

    private void union(int root1, int root2, int[] nodeRoot) {
        nodeRoot[root1] = root2;
    }
}
