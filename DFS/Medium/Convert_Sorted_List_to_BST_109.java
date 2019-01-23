package Leetcode.DFS.Medium;

import Leetcode.BFS.TreeNode;

import java.util.List;

public class Convert_Sorted_List_to_BST_109 {

    /**
     * Leetcode solution
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return findRoot(head, null);
    }

    public TreeNode findRoot(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = findRoot(head, slow);
        root.right = findRoot(slow.next, tail);

        return root;
    }

    public class ListNode {
        ListNode next;
        int val;
    }
}
