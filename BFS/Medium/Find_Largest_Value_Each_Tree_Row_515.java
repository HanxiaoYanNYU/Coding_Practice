package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Find_Largest_Value_Each_Tree_Row_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Dfs(root, 1, res);
        return res;
    }

    public void Dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;

        if (res.size() < level) res.add(root.val);

        Dfs(root.left, level + 1, res);
        Dfs(root.right, level + 1, res);
        if (root.val > res.get(level-1)) res.set(level-1, root.val);
    }
}
