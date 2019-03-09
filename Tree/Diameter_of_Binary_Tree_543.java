package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Diameter_of_Binary_Tree_543 {

    private int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        /*
        经过某一点的最长路径 = Math.max( 1) 向parent方向延伸的最长路径 + 向left-subtree延伸的最长路径,
                                      2)  向parent方向延伸的最长路径 + 向right-subtree延伸的最长路径,
                                      3)  向left-subtree延伸的最长路径 + 向right-subtree延伸的最长路径)

        但是经过分析，我们会发现并不需要计算情况 1) 和 2)。原因是在处理当前这个点之前，按顺序我们会先处理它的parent点，
        而parent点计算出的三种情况中 已经包含了它的子节点(也就是当前点) 1)和2)的情况。一直向前推，我们会推理到root节点。
        由于root节点没有parent，所以对于每一个节点我们只需考虑情况3)，然后不断更新max值即可。
        */
        findDepth(root);


        List<String> l = new ArrayList<>();
        l.removeAll(l);

        return diameter == Integer.MIN_VALUE ? 0 : diameter-1;
        // subtract 1 from diameter since length of path between two nodes is represented by the number
        // of edges between them.
    }

    private int findDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        diameter = Math.max(diameter, leftDepth + rightDepth + 1);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
