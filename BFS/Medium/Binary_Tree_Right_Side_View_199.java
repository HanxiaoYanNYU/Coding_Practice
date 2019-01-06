package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199 {

    /**
     * My BFS solution
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int val = 0;
            while (size > 0) {
                TreeNode node = q.poll();
                val = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size--;
            }
            res.add(val);
        }

        return res;
    }

    /**
     * Leetcode DFS solution, use level wisely. Similar to Problem No.102 Binary Tree Level Order Traversal
     * @param root
     * @return
     */
    public static List<Integer> rightSideView_lc(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Dfs(root, 1, res);
        return res;
    }

    public static void Dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;

        if (level > res.size()) res.add(root.val);

        Dfs(root.right, level + 1, res);
        Dfs(root.left, level + 1, res);
    }
}
