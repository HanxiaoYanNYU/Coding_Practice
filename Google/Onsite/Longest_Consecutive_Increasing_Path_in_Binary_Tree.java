package Leetcode.Google.Onsite;
import java.util.*;

public class Longest_Consecutive_Increasing_Path_in_Binary_Tree {

    // Java Program to find Maximum Consecutive
    // Path Length in a Binary Tree

    // To represent a node of a Binary Tree
    static class Node
    {
        Node left, right;
        int val;
    }

    // Create a new Node and return its address
    static Node newNode(int val)
    {
        Node temp = new Node();
        temp.val = val;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Returns the maximum consecutive Path Length
    static int maxPathLenUtil(Node root, int prev_val, int prev_len)
    {
        if (root == null)
            return prev_len;

        // Get the value of Current Node
        // The value of the current node will be
        // prev Node for its left and right children
        int cur_val = root.val;

        // If current node has to be a part of the
        // consecutive path then it should be 1 greater
        // than the value of the previous node
        if (cur_val == prev_val+1)
        {

            // a) Find the length of the Left Path
            // b) Find the length of the Right Path
            // Return the maximum of Left path and Right path
            return Math.max(maxPathLenUtil(root.left, cur_val, prev_len+1),
                    maxPathLenUtil(root.right, cur_val, prev_len+1));
        }

        // Find length of the maximum path under subtree rooted with this
        // node (The path may or may not include this node)
        int newPathLen = Math.max(maxPathLenUtil(root.left, cur_val, 1),
                maxPathLenUtil(root.right, cur_val, 1));

        // Take the maximum previous path and path under subtree rooted
        // with this node.
        return Math.max(prev_len, newPathLen);
    }

    // A wrapper over maxPathLenUtil().
    static int maxConsecutivePathLength(Node root)
    {
        // Return 0 if root is NULL
        if (root == null)
            return 0;

        // Else compute Maximum Consecutive Increasing Path
        // Length using maxPathLenUtil.
        return maxPathLenUtil(root, root.val-1, 0);
    }

    //Driver program to test above function
    public static void main(String[] args)
    {
        Node root = newNode(10);
        root.left = newNode(11);
        root.right = newNode(9);
        root.left.left = newNode(13);
        root.left.right = newNode(12);
        root.right.left = newNode(13);
        root.right.right = newNode(8);

        System.out.println("Maximum Consecutive Increasing Path Length is "+maxConsecutivePathLength(root));

    }


}
