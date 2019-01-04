package Leetcode.BFS.Easy;

import Leetcode.BFS.TreeNode;

public class Symmetric_Tree_101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return checkSubTree(root.left, root.right);
    }

    public static boolean checkSubTree(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        else if (left.val != right.val) return false;
        else return checkSubTree(left.left, right.right) && checkSubTree(left.right, right.left);
    }
}
