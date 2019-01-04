package Leetcode.BFS.Easy;

import Leetcode.BFS.TreeNode;

import java.util.*;

public class Binary_Tree_Level_Order_Traverl_II_107 {

    /**
     * My solution.
     * Record the number of nodes for each level.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            while (size > 0) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                size--;
            }

            res.add(0, list);
        }

        return res;
    }

    /**
     * Leetcode Solution
     * Use DFS to traverse the tree. Use a integer "level" to record the level of this node.
     *
     * If level > res.size(), it indicates we counter a node in a new level which has not been recorded in res yet,
     * so we will add a new list to res.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom_lc(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Dfs(root, 1, res);
        Collections.reverse(res);
        return res;
    }

    public void Dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;

        // If curr node is at a new level, we should add a new list to res which will store curr node
        if (res.size() < level) res.add(new ArrayList<>());

        // Then do dfs: 1) Left 2) Right 3) Self
        Dfs(root.left, level + 1, res);
        Dfs(root.right, level + 1, res);
        res.get(level-1).add(root.val);
    }
}
