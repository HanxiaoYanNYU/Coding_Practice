package Leetcode.Google.Onsite;

import Leetcode.BFS.TreeNode;

import java.util.Stack;

public class Inorder_Traverse_ith_Item {

    private int count = 1;
    private TreeNode item;

    public static void main(String[] args) {
        Inorder_Traverse_ith_Item m = new Inorder_Traverse_ith_Item();

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode nine = new TreeNode(9);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode eleven = new TreeNode(11);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode twelve = new TreeNode(12);

        TreeNode root = three;
        three.left = four; three.right = nine;
        four.left = one; four.right = six; nine.right = eleven; nine.left = null;
        one.left = two; one.right = seven; six.right = eight; six.left = null; eleven.left = twelve;
        eleven.right = null; two.left = null; two.right = null; seven.left = null; seven.right = null;
        eight.left = null; eight.right = null; twelve.left = null; twelve.right = null;

        TreeNode res = m.findItem_2(root, 7);
        if (res != null) System.out.println(res.val);
    }

    public TreeNode findItem(TreeNode root, int i) {
        if (root == null || i < 1) return null;
        inorder(root, i);
        return item;
    }

    private void inorder(TreeNode root, int i) {
        if (root == null) return;

        inorder(root.left, i);
        if (count == i) {
            item = root;
            count = i + 1;
            return;
        } else count++;
        inorder(root.right, i);
    }

    public TreeNode findItem_2(TreeNode root, int i) {
        if (root == null || i < 1) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode item = null;
        int count = 1;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (count == i) {
                item = curr;
                break;
            }
            count++;
            root = curr.right;
        }

        return item;
    }
}
