package Leetcode.Tree;

import Leetcode.BFS.TreeNode;

import java.util.*;

public class Serialize_Deserialize_BST_449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        String data = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode curr = q.poll();
                data += size == 1 ? curr.val + "|" : curr.val + ","; // 5|3,7|2,4,6,8|
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                size--;
            }
        }
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;

        List<List<TreeNode>> list = new ArrayList<>();
        for (String dataArray : data.split("\\|")) {
            list.add(new ArrayList<>());
            for (String nums : dataArray.split(",")) {
                int num = Integer.parseInt(nums);
                list.get(list.size()-1).add(new TreeNode(num));
            }
        }
        TreeNode root = list.get(0).get(0);
        root.left = buildTree(Integer.MIN_VALUE, root.val, 1, list);
        root.right = buildTree(root.val, Integer.MAX_VALUE, 1, list);
        return root;
    }

    private TreeNode buildTree(int left, int right, int level, List<List<TreeNode>> list) {
        if (level >= list.size()) return null;
        TreeNode child = null;
        for (TreeNode node : list.get(level)) {
            if (node.val > left && node.val < right) {
                child = node;
                list.get(level).remove(0);
                break;
            }
        }
        if (child == null) return null;
        else {
            child.left = buildTree(Integer.MIN_VALUE, child.val, level+1, list);
            child.right = buildTree(child.val, right, level+1, list);
            return child;
        }
    }

    /**
     * Scott's solution, use the property of preorder traverse
     * @param root
     * @return
     */
    public String serialize_preorder(TreeNode root) {

        if (root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        String data = "";
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            data += curr.val + " ";
            if (curr.right != null) stack.add(curr.right);
            if (curr.left != null) stack.add(curr.left);
        }
        data.trim();
        return data;
    }

    public TreeNode deserialize_preorder(String data) {
        if (data == null || data.equals("")) return null;
        String[] datas = data.split(" ");
        int[] nums = new int[datas.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(datas[i]);
        }
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        TreeNode curr = new TreeNode(nums[start]);
        int index;
        for (index = start+1; index <= end; index++) {
            if (nums[index] > curr.val) break;
        }
        curr.left = buildTree(nums, start+1, index-1);
        curr.right = buildTree(nums, index, end);
        return curr;
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);


        five.left = three; five.right = six;
        three.left = two; three.right = four;
        two.left = one;

        Serialize_Deserialize_BST_449 d = new Serialize_Deserialize_BST_449();
        String res = d.serialize_preorder(five);
        System.out.println(res);

        //TreeNode r = d.deserialize_preorder(res);
    }
}
