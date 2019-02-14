package Leetcode.Google.Onsite;

import Leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vertical_Order_Traversal_of_Binary_Tree_987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Node> nodes = new ArrayList<>();
        preorder(root, new Node(0,0), nodes);
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) return o1.x - o2.x; // x1 != x2
                if (o1.y != o2.y) return o2.y - o1.y; // since y <= 0, x1 == x2 && y1 != y2
                else return o1.val - o2.val; // x1 == x2 && y1 == y2
            }
        });

        Node pre = null;
        for (Node curr : nodes) {
            if (pre == null || pre.x != curr.x) res.add(new ArrayList<>());
            res.get(res.size() - 1).add(curr.val);
            pre = curr;
        }

        return res;
    }

    private void preorder(TreeNode root, Node node, List<Node> nodes) {
        if (root == null) return;

        node.val = root.val;
        nodes.add(node); // root
        preorder(root.left, new Node(node.x-1, node.y-1), nodes); // go left, vector: -1,-1
        preorder(root.right, new Node(node.x+1, node.y-1), nodes); // go right, vector: +1,-1
    }

    class Node {
        public int x;
        public int y;
        public int val;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
