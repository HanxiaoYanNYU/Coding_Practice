package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class House_Robber_III_337 {

    /**
     * AC solution but very slow, since it compute same sub-problems over and over again
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int maxMoneyIfRobRoot = root.val;
        if (root.left != null) {
            maxMoneyIfRobRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            maxMoneyIfRobRoot += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(maxMoneyIfRobRoot, // rob the root
                0 + rob(root.left) + rob(root.right)); // do not rob the root

    }

    public int rob_dp(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>(); // max money can rob start from this node(root)
        return robMoney(root, map);
    }

    public int robMoney(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int maxIfRobRoot = root.val;
        if (root.left != null) maxIfRobRoot += robMoney(root.left.left, map) + robMoney(root.left.right, map);
        if (root.right != null) maxIfRobRoot += robMoney(root.right.left, map) + robMoney(root.right.right, map);

        int max = Math.max(maxIfRobRoot, 0 + robMoney(root.left, map) + robMoney(root.right, map));
        map.put(root, max);

        return max;
    }
}
