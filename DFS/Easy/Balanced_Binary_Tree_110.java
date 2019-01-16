package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

public class Balanced_Binary_Tree_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int[] leftTree = checkSubTree(root.left, 1); // define root's level as 0
        int[] rightTree = checkSubTree(root.right, 1);
        return leftTree[0]==1 && rightTree[0]==1 && Math.abs(leftTree[1] - rightTree[1])<=1;
    }

    public int[] checkSubTree(TreeNode root, int currLevel) {
        if (root == null) {
            return new int[]{1, currLevel}; // int[0] indicates it is a balanced tree
        }

        int[] leftTree = checkSubTree(root.left, currLevel + 1); // define root's level as 0
        int[] rightTree = checkSubTree(root.right, currLevel + 1);

        int[] res = new int[2];
        if (leftTree[0]==1 && rightTree[0]==1 && Math.abs(leftTree[1] - rightTree[1])<=1) res[0] = 1;
        else res[0] = 0;
        res[1] = Math.max(leftTree[1], rightTree[1]);

        return res;
    }
}
