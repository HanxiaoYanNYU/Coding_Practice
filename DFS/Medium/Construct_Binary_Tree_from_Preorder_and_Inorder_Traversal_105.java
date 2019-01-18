package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(0, 0, preorder.length - 1, preorder, valToIndex);
    }

    public TreeNode build(int rootIndex, int left, int right, int[] preorder,                                                                            Map<Integer,Integer> valToIndex) {

        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        int rootPosition = valToIndex.get(rootVal);

        int leftCount = rootPosition - left;
        int rightCount = right - rootPosition;

        if (leftCount < 1) root.left = null;
        else {
            root.left = build(rootIndex + 1, left, rootPosition - 1, preorder, valToIndex);
        }

        if (rightCount < 1) root.right = null;
        else {
            root.right = build(rootIndex + leftCount + 1, rootPosition + 1, right, preorder, valToIndex);
        }

        return root;
    }
}
