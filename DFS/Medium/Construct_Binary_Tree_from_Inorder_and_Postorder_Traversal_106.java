package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, inorder.length - 1, map, postorder);
    }

    /**
     * @param l is the left boundary of inorder
     * @param r is the right boundary of inorder
     * @param rootPos is the next root's position in postorder
     * @param map helps to find root's position in inorder
     * @param post postorder
     * @return
     */
    public TreeNode build(int l, int r, int rootPos, Map<Integer, Integer> map, int[] post) {
        if (l > r) return null;

        TreeNode root = new TreeNode(post[rootPos]);
        // (r-map.get(root.val)) is the number of nodes on the right of root node
        // inorder array: [l ... rootVal ... r]
        root.left = build(l, map.get(root.val)-1, rootPos-(r-map.get(root.val))-1, map, post);
        root.right = build(map.get(root.val)+1, r, rootPos-1, map, post);
        return root;
    }
}
