package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

public class Trim_Binary_Search_Tree_669 {

    /**
     * LeetCode solution.
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) root = trimBST(root.right, L, R);
        else if (root.val > R) root = trimBST(root.left, L, R);
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}
