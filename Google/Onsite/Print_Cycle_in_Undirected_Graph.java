package Leetcode.Google.Onsite;

import java.util.*;

public class Print_Cycle_in_Undirected_Graph {

    public static void main(String[] args) {
        Print_Cycle_in_Undirected_Graph g = new Print_Cycle_in_Undirected_Graph();
        Node six = g.new Node(6, new int[]{5,10});
        Node ten = g.new Node(10, new int[]{6});
        Node five = g.new Node(5, new int[]{6,1});
        Node one = g.new Node(1, new int[]{5,2,4,7});
        Node two = g.new Node(2, new int[]{1,3});
        Node three = g.new Node(3, new int[]{2,4});
        Node four = g.new Node(4, new int[]{1,3,9});
        Node nine = g.new Node(9, new int[]{4});
        Node seven = g.new Node(7, new int[]{1,8});
        Node eight = g.new Node(8, new int[]{7});

        List<Node> list = new ArrayList<>();
        list.add(six); list.add(ten); list.add(five); list.add(one); list.add(two); list.add(three);
        list.add(four); list.add(nine); list.add(seven); list.add(eight);

        List<Node> res = g.printCycle(list);
        for (Node r : res) {
            System.out.println(r.id);
        }
    }

    public List<Node> printCycle(List<Node> list) {
        // construct id to node map
        Map<Integer, Node> map = new HashMap<>();
        for (Node node : list) {
            map.put(node.id, node);
        }

        // start from an arbitrary node, do dfs to find a node in cycle
        List<Node> nodeInCycle = new ArrayList<>();
        findCycleNode(null, list.get(0), map, new HashSet<>(), nodeInCycle);

        // start from the node in cycle, do backtrack to find this node itself
        Node node = nodeInCycle.get(0);
        List<Node> cycle = new ArrayList<>();
        backtrack(null, node, node, map, new HashSet<>(),new ArrayList<>(), cycle);

        return cycle;
    }

    private void findCycleNode(Node from,  Node curr, Map<Integer, Node> map, Set<Integer> visited,
                               List<Node> nodeInCycle) {
        visited.add(curr.id);

        for (Integer neighborId : map.get(curr.id).neighbors) {
            if (from != null && neighborId == from.id) continue;
            if (visited.contains(neighborId)) {
                nodeInCycle.add(curr);
                return;
            }
            findCycleNode(curr, map.get(neighborId), map, visited, nodeInCycle);
        }
    }

    private void backtrack(Node from, Node curr, Node target,  Map<Integer, Node> map, Set<Node> visited,
                           List<Node> track, List<Node> cycle) {
        visited.add(curr);

        track.add(curr);
        for (Integer neighborId : map.get(curr.id).neighbors) {
            if (from != null && from.id == neighborId) continue;
            if (neighborId == target.id) {
                for (Node t : track) cycle.add(t);
                return;
            }
            if (visited.contains(map.get(neighborId))) continue;
            backtrack(curr, map.get(neighborId), target, map, visited, track, cycle);
        }
        track.remove(track.size() - 1);
    }

    class Node {
        public int id;
        public List<Integer> neighbors;

        public Node(int id, int[] neighbors) {
            this.id = id;
            this.neighbors = new ArrayList<Integer>();
            for (Integer n : neighbors) {
                this.neighbors.add(n);
            }
        }
    }
}
