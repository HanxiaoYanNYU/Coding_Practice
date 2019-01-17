package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

public class Minimum_Depth_of_Binary_Tree_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return depth(root);
    }

    public int depth(TreeNode root) {
        if (root.left == null && root.right == null) return 1;

        int leftDepth = root.left == null ? Integer.MAX_VALUE : depth(root.left);
        int rightDepth = root.right == null ? Integer.MAX_VALUE : depth(root.right);
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
