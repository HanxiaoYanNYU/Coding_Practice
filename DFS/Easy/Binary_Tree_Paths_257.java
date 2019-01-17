package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;

        Dfs(root, list, "");
        return list;
    }

    public void Dfs(TreeNode root, List<String> list, String curr) {
        if (root.left == null && root.right == null) {
            list.add(curr + root.val);
            return;
        }

        if (root.left != null) Dfs(root.left, list, curr + root.val + "->");
        if (root.right != null) Dfs(root.right, list, curr + root.val + "->");
    }
}
