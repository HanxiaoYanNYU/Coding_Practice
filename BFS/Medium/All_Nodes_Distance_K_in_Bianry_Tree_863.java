package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.*;

public class All_Nodes_Distance_K_in_Bianry_Tree_863 {

    /**
     * My BFS solution
     *
     * Reconstruct the undirected graph from binary tree. Then bfs find level K according to target
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        List<Integer> res = new ArrayList<>();
        if (!graph.containsKey(target.val)) return res;
        else {
            if (K == 0) {
                res.add(target.val);
                return res;
            } else {
                Set<Integer> visited = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(target.val);
                visited.add(target.val);
                while (K > 0) {
                    K--;
                    int size = q.size();
                    while (size > 0) {
                        size--;
                        int curr = q.poll();
                        for (int neighbor : graph.get(curr)) {
                            if (visited.contains(neighbor)) continue;
                            q.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                while (!q.isEmpty()) {
                    res.add(q.poll());
                }
                return res;
            }
        }
    }

    public void buildGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!graph.containsKey(node.val)) graph.put(node.val, new ArrayList());
            if (node.left != null) {
                graph.get(node.val).add(node.left.val);
                q.add(node.left);
                if (!graph.containsKey(node.left.val)) graph.put(node.left.val, new ArrayList());
                graph.get(node.left.val).add(node.val);
            }
            if (node.right != null) {
                graph.get(node.val).add(node.right.val);
                q.add(node.right);
                if (!graph.containsKey(node.right.val)) graph.put(node.right.val, new ArrayList());
                graph.get(node.right.val).add(node.val);
            }
        }
    }
}
