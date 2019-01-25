package Leetcode.DFS.Medium;

public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {

    /*
      Traverse all root nodes at same level to connect all children at next level.
     */
    public void connect(TreeLinkNode root) {

        while (root != null) {

            TreeLinkNode nextLevelDummy = new TreeLinkNode(-1);
            TreeLinkNode childCurr = nextLevelDummy;

            // Connect this root's left child and right child if possible
            while (root != null) {
                if (root.left != null) {
                    childCurr.next = root.left;
                    childCurr = childCurr.next;
                }
                if (root.right != null) {
                    childCurr.next = root.right;
                    childCurr = childCurr.next;
                }
                root = root.next; // Go to next root at this level
            }

            root = nextLevelDummy.next; // Go to next level
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
   }
}
