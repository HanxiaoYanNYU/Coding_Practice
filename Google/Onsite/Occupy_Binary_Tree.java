package Leetcode.Google.Onsite;

public class Occupy_Binary_Tree {

    private TreeNode parent;

    public TreeNode occupyTree(TreeNode root, TreeNode red) {
        if (root == null) return null;
        if (red == null) return root; // if there is not red person on the tree

        int numFromParent, numFromLeft, numFromRight;
        numFromParent = countNum(root, red);
        numFromLeft = countNum(red.left, red);
        numFromRight = countNum(red.right, red);

        int max = Math.max(numFromParent, Math.max(numFromLeft, numFromRight));
        if (max == numFromParent) return parent;
        else if (max == numFromLeft) return red.left;
        else return red.right;
    }

    private int countNum(TreeNode root, TreeNode red) {
        if (root == null || root == red) return 0;

        if (root.left == red || root.right == red) parent = root;
        return 1 + countNum(root.left, red) + countNum(root.right, red);
    }

    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {this.key = key;}
    }
}
