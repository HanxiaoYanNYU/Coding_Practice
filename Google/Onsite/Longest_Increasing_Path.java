package Leetcode.Google.Onsite;

import java.util.List;

public class Longest_Increasing_Path {

    // n-nary tree longest ascending path，就是子树里最长的递增path长度

    public int findLongestPath(TreeNode root) {
        if (root == null) return 0;
        return findPath(root, root.val, 0);
    }

    public int findPath(TreeNode curr, int parentVal, int preLen) {
        if (curr == null) return preLen;

        if (curr.val >= parentVal) {
            int max = -1;
            for (TreeNode child : curr.children) {
                max = Math.max(max, findPath(child, curr.val, preLen + 1));
            }
            return max;
        } else {
            int newLen = -1;
            for (TreeNode child : curr.children) {
                newLen = Math.max(newLen, findPath(child, curr.val, preLen + 1));
            }
            return Math.max(preLen, newLen);
        }
    }

    class TreeNode {
        public int val;
        public List<TreeNode> children;
        public TreeNode(int val, List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }
    }
}
