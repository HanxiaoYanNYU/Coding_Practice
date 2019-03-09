package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique_BST_II_95 {

    /**
     * LeetCode solution
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) return res;
        return generateTree(1, n); // Generate all possible left and right subtrees rooted at 1 to n
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> roots = new ArrayList<>();

        if (start > end) { roots.add(null); return roots; } // only one possible root: null

        for (int i = start; i <= end; i++) {
            for (TreeNode leftChild : generateTree(start, i-1)) {
                for (TreeNode rightChild : generateTree(i+1, end)) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftChild;
                    node.right = rightChild;
                    roots.add(node);
                }
            }
        }
        return roots;
    }
}
