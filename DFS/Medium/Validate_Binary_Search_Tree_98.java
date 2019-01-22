package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.Stack;

public class Validate_Binary_Search_Tree_98 {

    public boolean isValidBST(TreeNode root) {

        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode curr = s.pop();
            if (pre != null && pre.val >= curr.val) return false;
            pre = curr;
            root = curr.right;
        }
        return true;
    }
}
