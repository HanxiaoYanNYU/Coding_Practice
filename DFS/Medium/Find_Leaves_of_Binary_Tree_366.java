package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Find_Leaves_of_Binary_Tree_366 {

    /**
     * Leetcode solution, count level from leaf. Just the opposite way of counting level to another dfs problem
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        findHeight(root, res);
        return res;
    }

    public int findHeight(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;

        int leftH = findHeight(root.left, res);
        int rightH = findHeight(root.right, res);
        int rootH = Math.max(leftH, rightH) + 1;

        if (rootH > res.size()) res.add(new ArrayList<>());
        res.get(rootH - 1).add(root.val);
        return rootH;
    }
}
