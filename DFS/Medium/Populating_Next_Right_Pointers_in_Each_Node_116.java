package Leetcode.DFS.Medium;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {

    /**
     * My recursive solution
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        connectTwo(root.left, root.right);
    }

    /*
    Connect two subtrees:
    1) connect two root nodes (leftRoot -> rightRoot)
    2) connect two children of leftRoot (leftRoot.left -> leftRoot.right)
    3) connect two children of rightRoot(rightRoot.left -> rightRoot.right)
    4) connect child nodes belongs to different root (leftRoot.right -> rightRoot.left)
    */
    public void connectTwo(TreeLinkNode leftRoot, TreeLinkNode rightRoot) {
        if (leftRoot == null) return;

        leftRoot.next = rightRoot;

        connectTwo(leftRoot.left, leftRoot.right);
        connectTwo(leftRoot.right, rightRoot.left);
        connectTwo(rightRoot.left, rightRoot.right);
    }

    public class TreeLinkNode {
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
    }
}
