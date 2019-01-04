package Leetcode.BFS.Easy;

import Leetcode.BFS.TreeNode;

public class Min_Depth_of_Binary_Tree_111 {

    /**
     * My solution
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return findMin(root);
    }

    public static int findMin(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right == null) return 1 + findMin(root.left);
        else if (root.left == null) return 1 + findMin(root.right);
        else return 1 + Math.min(findMin(root.left), findMin(root.right));
    }

    /**
     * Leetcode solution
     * @param root
     * @return
     */
    public static int minDepth_lc(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth_lc(root.left);
        int rightDepth = minDepth_lc(root.right);
        /*
        if (leftDepth == 0 && rightDepth == 0) return 1;
        else if (leftDepth == 0 && rightDepth != 0) return rightDepth + 1;
        else if (leftDepth != 0 && rightDepth == 0) return leftDepth + 1;
        else return Math.min(leftDepth, rightDepth) + 1;

        These four lines of code can be replaced by the following 1 line of code
        */
        return (leftDepth == 0 || rightDepth == 0) ? (leftDepth + rightDepth) + 1 :
                                                     Math.min(leftDepth, rightDepth) + 1;
    }

}
