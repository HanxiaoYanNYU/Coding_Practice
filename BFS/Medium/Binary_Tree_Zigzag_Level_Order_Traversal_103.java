package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Dfs(root, 1, res);
        return res;
    }

    public static void Dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;

        if (level > res.size()) res.add(new ArrayList<>());

        Dfs(root.left, level + 1, res);
        Dfs(root.right, level + 1, res);
        if (level % 2 == 0) {
            res.get(level - 1).add(0, root.val);
        } else {
            res.get(level - 1).add(root.val);
        }
    }
}
