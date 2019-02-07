package Leetcode.Google.Onsite;

import Leetcode.BFS.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
   There is one extra edge in a binary tree, find and fix it

   follow up: if this is a binary search tree?
 */
public class Binary_Tree_Find_Extra_Edge {

    public static TreeNode fixTree(TreeNode root) {
        if (root == null) return null;

        Set<TreeNode> hasParent = new HashSet<>();
        hasParent.add(root);

        dfs(root, hasParent);
        return root;
    }

    public static void dfs(TreeNode root, Set<TreeNode> hasParent) {

        if (root.left != null) {
            if (hasParent.contains(root.left)) {
                root.left = null;
                return;
            }
            else {
                hasParent.add(root.left);
                dfs(root.left, hasParent);
            }
        }

        if (root.right != null) {
            if (hasParent.contains(root.right)) {
                root.right = null;
                return;
            }
            else {
                hasParent.add(root.right);
                dfs(root.right, hasParent);
            }
        }
    }

    public static TreeNode buildTestCase() {
        /*
                 7
               5   9
             3   8
             [5,8], [9,8]
         */

        TreeNode seven = new TreeNode(7);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);

        seven.left = five;
        seven.right = nine;

        five.left = three;
        five.right = eight;

        nine.left = eight;
        nine.right = null;

        three.left = null;
        three.right = null;

        eight.left = null;
        eight.right = null;

        return seven;
    }

    public static TreeNode buildTestCase_pointToRoot() {
        /*
                 7
               5   9
             3   8
             [3, 7]
         */

        TreeNode seven = new TreeNode(7);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);

        seven.left = five;
        seven.right = nine;

        five.left = three;
        five.right = eight;

        nine.left = null;
        nine.right = null;

        three.left = seven;
        three.right = null;

        eight.left = null;
        eight.right = null;

        return seven;
    }

    public static TreeNode buildTestCase_threePointItself() {
        /*
                 7
               5   9
             3   8
             [3, 3]
         */

        TreeNode seven = new TreeNode(7);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);

        seven.left = five;
        seven.right = nine;

        five.left = three;
        five.right = eight;

        nine.left = null;
        nine.right = null;

        three.left = three;
        three.right = null;

        eight.left = null;
        eight.right = null;

        return seven;
    }

    /**
     * In order traverse
     * @param root
     */
    public static void printTree(TreeNode root) {
        if (root == null) return;

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
