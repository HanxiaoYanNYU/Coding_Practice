package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Dfs(root, 1, res);
        return res;
    }

    public static void Dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;

        if (res.size() < level) res.add(new ArrayList<>()); // Add a new list to store this level's elements
        Dfs(root.left, level + 1, res);
        Dfs(root.right, level + 1, res);
        res.get(level - 1).add(root.val);
    }
}
