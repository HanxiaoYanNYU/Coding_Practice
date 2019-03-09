package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Count_Univalue_Subtrees_250 {

    /**
     * My early solution, not good enough
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        return countSubtree(root, new HashSet<>());
    }

    private int countSubtree(TreeNode root, Set<Integer> parentSet) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            parentSet.add(root.val);
            return 1;
        }

        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();

        int leftCount = countSubtree(root.left, left);
        int rightCount = countSubtree(root.right, right);

        if ((left.isEmpty() || left.contains(root.val) && left.size() == 1)
                && (right.isEmpty() || right.contains(root.val) && right.size() == 1)) {
            return 1 + leftCount + rightCount;
        } else {
            parentSet.add(0); parentSet.add(1); // Add any two different value to set, since we just
                                                // want to make the size of set != 1
            return leftCount + rightCount;
        }
    }

    /**
     * My updated solution, runs fast and make more sense
     */
    private int count = 0;

    public int countUnivalSubtrees_second(TreeNode root) {
        isUnique(root);
        return count;
    }

    private boolean isUnique(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        String s = "111";
        s.trim();

        boolean isLeftUnique = isUnique(root.left);
        boolean isRightUnique = isUnique(root.right);

        int leftVal = root.left == null ? root.val : root.left.val;
        int rightVal = root.right == null ? root.val : root.right.val;

        if (isLeftUnique && isRightUnique && root.val == leftVal && root.val == rightVal) {
            count++;
            return true;
        } else return false;
    }
}
