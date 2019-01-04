package Leetcode.BFS.Easy;

import java.util.List;

public class Max_Depth_of_Nary_Tree_559 {

    public int maxDepth(Node root) {
        if (root == null) return 0;

        int depth = 1; // The root itself has one level
        for (Node c : root.children) {
            depth = Math.max(depth, maxDepth(c) + 1); // If root's children is empty, then code will skip for loop
        }
        return depth;
    }

    public class Node {
        int val;
        List<Node> children;

        public Node (int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
