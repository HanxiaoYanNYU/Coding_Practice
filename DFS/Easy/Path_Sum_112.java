package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

public class Path_Sum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return checkSum(root, sum);
    }

    public boolean checkSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        if (root.left != null) {
            boolean leftTree = checkSum(root.left, sum - root.val);
            if (leftTree) return true;
        }

        boolean rightTree = false;
        if (root.right != null) {
            rightTree = checkSum(root.right, sum - root.val);
        }

        return rightTree;
    }
}
