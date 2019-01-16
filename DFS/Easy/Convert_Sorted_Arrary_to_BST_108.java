package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

public class Convert_Sorted_Arrary_to_BST_108 {

    /**
     * My solution, a little trivial
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        leftTree(root, left, mid - 1, nums);
        rightTree(root, mid + 1, right, nums);
        return root;
    }

    public void leftTree(TreeNode root, int left, int right, int[] nums) {
        if (left > right) {
            root.left = null;
            return;
        }
        int mid = left + (right - left) / 2;
        TreeNode leftNode = new TreeNode(nums[mid]);
        root.left = leftNode;
        leftTree(root.left, left, mid - 1, nums);
        rightTree(root.left, mid + 1, right, nums);
    }

    public void rightTree(TreeNode root, int left, int right, int[] nums) {
        if (left > right) {
            root.right = null;
            return;
        }
        int mid = left + (right - left) / 2;
        TreeNode rightNode = new TreeNode(nums[mid]);
        root.right = rightNode;
        leftTree(root.right, left, mid - 1, nums);
        rightTree(root.right, mid + 1, right, nums);
    }

    /**
     * Leetcode Solution, elegant
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST_lc(int[] nums) {
        if (nums.length == 0) return null;

        return buildTree(0, nums.length - 1, nums);
    }

    public TreeNode buildTree(int left, int right, int[] nums) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildTree(left, mid - 1, nums);
        node.right = buildTree(mid + 1, right, nums);

        return node;
    }
}
