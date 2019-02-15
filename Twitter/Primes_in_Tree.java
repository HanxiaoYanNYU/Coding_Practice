package Leetcode.Twitter;


import java.util.*;

public class Primes_in_Tree {

    public static void main(String[] args) {
        Primes_in_Tree p = new Primes_in_Tree();
        int n = 8;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> queries = new ArrayList<>();

        first.addAll(Arrays.asList(1,1,3,3,4,5,7));
        second.addAll(Arrays.asList(3,5,2,4,6,7,8));
        values.addAll(Arrays.asList(2, 10, 5, 9, 11, 3, 4, 23));
        queries.addAll(Arrays.asList(1,2,3,4,5,6,7,8));

        List<Integer> res = p.findPrimes(n, first, second, values, queries);
        for (Integer r : res) {
            System.out.println(r);
        }
    }

    public List<Integer> findPrimes(int n, List<Integer> first, List<Integer> second,
                                            List<Integer> values, List<Integer> queries) {
        int root = 1;

        // build base cases
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPrime(values.get(i))) nums[i] = 1;
            else nums[i] = 0;
        }

        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < first.size(); i++) {
            if (!graph.containsKey(first.get(i))) graph.put(first.get(i), new ArrayList<>());
            if (!graph.containsKey(second.get(i))) graph.put(second.get(i), new ArrayList<>());
            graph.get(first.get(i)).add(second.get(i));
            graph.get(second.get(i)).add(first.get(i));
        }

        // find leaves
        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
            int nodeId = e.getKey();
            List<Integer> neighbors = e.getValue();
            if (neighbors.size() == 1) leaves.add(nodeId);
        }

        // update parent node, remove leaf from leaves, add new leaf to leaves
        while (!leaves.isEmpty()) {
            int leaf = leaves.poll();
            int parent = graph.get(leaf).get(0);
            nums[parent-1] += nums[leaf-1]; // update parent node's prime number
            graph.get(parent).remove(Integer.valueOf(leaf)); // remove leaf from graph
            if (graph.get(parent).size() == 1 && parent != root) leaves.add(parent);
        }

        // query the tree
        List<Integer> res = new ArrayList<>();
        for (Integer q : queries) {
            res.add(nums[q-1]);
        }
        return res;
    }

    private boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
