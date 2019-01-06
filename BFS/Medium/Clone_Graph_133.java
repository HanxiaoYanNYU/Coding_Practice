package Leetcode.BFS.Medium;

import java.util.*;

public class Clone_Graph_133 {

    /**
     * Leetcode Solution. DFS.
     * The key part of this solution is to define a recursive method "cloneNode", which will take the originNode
     * and make a copy of the NODE as well as its RELATIONSHIPS to its neighbors.
     *
     * @param node
     * @return
     */
    public static UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> originToClone = new HashMap<>();
        return cloneNode(node, originToClone);
    }

    public static UndirectedGraphNode cloneNode(UndirectedGraphNode originNode, Map<UndirectedGraphNode, UndirectedGraphNode> originToClone) {
        if (originToClone.containsKey(originNode)) return originToClone.get(originNode);

        UndirectedGraphNode cloneNode = new Clone_Graph_133().new UndirectedGraphNode(originNode.label);
        originToClone.put(originNode, cloneNode);

        for (UndirectedGraphNode originNeighbor : originNode.neighbors) {
            UndirectedGraphNode cloneNeighbor = cloneNode(originNeighbor, originToClone);
            cloneNode.neighbors.add(cloneNeighbor);
        }

        return cloneNode;
    }

    /**
     * Leetcode Solution. BFS
     * This solution has two steps: 1) copy nodes 2) after copied all of the nodes, copy nodes' relationships
     *
     * @param node
     * @return
     */
    public static UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
        if (node == null) return null;

        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> originToClone = new HashMap<>();
        q.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode originNode = q.poll();
            if (!originToClone.containsKey(originNode)) {
                UndirectedGraphNode cloneNode = new Clone_Graph_133().new UndirectedGraphNode(originNode.label);
                originToClone.put(originNode, cloneNode);
            }
            for (UndirectedGraphNode originNeighbor : originNode.neighbors) {
                if (!originToClone.containsKey(originNeighbor)) {
                    q.add(originNeighbor);
                }
            }
        }

        for (UndirectedGraphNode originNode : originToClone.keySet()) {
            UndirectedGraphNode cloneNode = originToClone.get(originNode);
            for (UndirectedGraphNode originNeighbor : originNode.neighbors) {
                cloneNode.neighbors.add(originToClone.get(originNeighbor));
            }
        }

        return originToClone.get(node);
    }

    public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
