package Leetcode.BFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Bottom_Left_Tree_Value_513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int val = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) val = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return val;
    }
}
