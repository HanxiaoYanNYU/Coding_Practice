package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return Integer.MAX_VALUE;
        TreeNode curr = stack.pop();
        int value = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
        return value;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode fiftien = new TreeNode(15);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);

        seven.left = three;
        seven.right = fiftien;
        three.left = null;
        three.right = null;
        fiftien.left = nine;
        fiftien.right = twenty;
        nine.left = null;
        nine.right = null;
        twenty.left = null;
        twenty.right = null;

        BSTIterator iterator = new BSTIterator(seven);
        iterator.next();
        iterator.next();
    }
}
