package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List_114 {

    /**
     * Leetcode intuitive solution
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }

    /**
     * Leetcode another solution, Dfs right -> left -> root, attach last elements to tail
     */
    TreeNode rightTail = null;

    /* Dfs: right -> left -> root */
    public void flatten_lc(TreeNode root) {
        if (root == null) return;

        flatten_lc(root.right);
        flatten_lc(root.left);

        root.left = null;
        root.right = rightTail; // attach tail to each node
        rightTail = root; // point start of tail to this root node
    }
}
