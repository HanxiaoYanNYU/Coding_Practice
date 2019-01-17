package Leetcode.DFS.Easy;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similiar_Tree_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        Dfs(root1, list1); Dfs(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public void Dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) Dfs(root.left, list);
        if (root.right != null) Dfs(root.right, list);
    }
}
