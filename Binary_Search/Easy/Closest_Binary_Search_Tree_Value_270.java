package Leetcode.Binary_Search.Easy;

public class Closest_Binary_Search_Tree_Value_270 {

    /***
     * Recursive solution, O(logn)
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        return findValue(root, target, root.val);
    }

    private int findValue(TreeNode root, double target, int pre_value) {
        if (root == null) return pre_value;

        int curr_value = Math.abs(root.val - target) > Math.abs(pre_value - target) ? pre_value : root.val;
        if (root.val > target) {
            return findValue(root.left, target, curr_value);
        } else if (root.val < target) {
            return findValue(root.right, target, curr_value);
        }
        return root.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
