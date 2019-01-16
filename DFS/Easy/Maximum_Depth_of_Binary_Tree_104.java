package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

public class Maximum_Depth_of_Binary_Tree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
