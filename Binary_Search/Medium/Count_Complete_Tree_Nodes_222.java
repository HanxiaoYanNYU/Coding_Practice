package Leetcode.Binary_Search.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Count_Complete_Tree_Nodes_222 {

    /**
     * Time Limit Exceed, O(n)
     *
     * @param root
     * @return
     */
    public int countNodes_1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                count++;
            }
            if (curr.right != null) {
                q.add(curr.right);
                count++;
            }
        }
        return count;
    }

    /**
     * Using binary search idea, reduce either left or right tree at each time
     * O(logn * logn)
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int heightLeft = findHeight(root.left);
        int heightRight = findHeight(root.right);
        if (heightLeft == heightRight) {
            // Right sub-tree incomplete, left is complete. Add root node itself, left sub-tree and right-sub tree
            return 1 + (int)(Math.pow(2, heightLeft) - 1) + countNodes(root.right);
        } else {
            // Left sub-tree may incomplete, right is complete. Add root node itself, right sub and left sub
            return 1 + (int)(Math.pow(2, heightRight) - 1) + countNodes(root.left);
        }
    }

    public int findHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    /**
     * My solution
     *
     * @param root
     * @return
     */
    public static int countNodes_my(TreeNode root) {
        if (root == null) return 0;

        int[] level = countLevel(root.left);
        int leftLevel = level[0];
        int rightLevel = level[1];
        if (leftLevel == -1) return 1;
        else if (leftLevel == rightLevel) {
            // Left subtree is complete
            return (int)Math.pow(2, leftLevel) + countNodes_my(root.right);
        } else {
            // Right subtree is complete
            return (int)Math.pow(2, rightLevel) + countNodes_my(root.left);
        }
    }

    public static int[] countLevel(TreeNode root) {
        if (root == null) return new int[]{-1, -1};

        TreeNode left = root;
        int leftCount = 0;
        while (left != null) {
            leftCount++;
            left = left.left;
        }

        TreeNode right = root;
        int rightCount = 0;
        while (right != null) {
            rightCount++;
            right = right.right;
        }

        return new int[]{leftCount, rightCount};
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
