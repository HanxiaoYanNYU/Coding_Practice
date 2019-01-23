package Leetcode.DFS.Medium;

import java.util.*;

public class Reconstruct_Itinerary_332 {

    /**
     * Greedy + Post Order Traverse
     *
     * YouTube solution: https://www.youtube.com/watch?v=4udFSOWQpdg&t=652s
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return res;

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(t[0], pq);
            }
            map.get(t[0]).add(t[1]);
        }

        postOrderTrav("JFK", map, res);
        Collections.reverse(res);
        return res;
    }

    /*
    * The key part here is to think of the graph as a tree. You always go "left" first (left indicates smaller
    * airport code), if you stop at left, then you go "right" (larger airport code). If at any point you go right,
    * it means you cannot finish all fight by just go left, you have to give up traverse the smaller airport code
    * at least at this point by going right.
    * */
    public void postOrderTrav(String from, Map<String, PriorityQueue<String>> map, List<String> res) {
        /*
        The following code is actually post order traverse
        It is similar to:
            traverse(root.left); // smaller letter airport is "left", we look at smaller one first
            traverse(root.right);
            print(root);

        The reason we use while loop is we may have more than 2 children:
                 SFO
                  ^
                  |
         ATL <- [JFK] -> SJC

        */
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            String to = map.get(from).poll();
            postOrderTrav(to, map, res);
        }
        res.add(from);
    }
}
