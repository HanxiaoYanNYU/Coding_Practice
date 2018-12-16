package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_in_BST_230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        findK(root, k, list);
        return list.get(list.size() - 1); // The last element is the Kth smallest one.
    }

    public void findK(TreeNode root, int k, List<Integer> list) {
        if (root == null || list.size() == k) return;

        findK(root.left, k, list);
        if (list.size() == k) return; // If we already find the Kth element after searching left sub-tree
                                      // we need to return immediately. Otherwise, list will include extra element.

        list.add(root.val);
        findK(root.right, k, list);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}
}
