package Leetcode.BFS.Medium;

import java.util.*;

public class Cheapest_Flights_Within_K_Sops_787 {

    /**
     * Leetcode Solution, manipulate Dijkstra’s shortest path algorithm
     *
     * Note: Dijkstra’s shortest path algorithm is a Greedy Algorithm, which means it can achieve the best
     * result by selecting shortest path each time
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] f : flights) {
            if (!graph.containsKey(f[0])) graph.put(f[0], new HashMap<>());
            graph.get(f[0]).put(f[1], f[2]); // {src, {dst, price}}
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        pq.add(new int[]{src, 0, K + 1}); // destCity, price, stops

        while (!pq.isEmpty()) {
            int[] city = pq.poll();
            int destCity = city[0];
            int price = city[1];
            int stops = city[2];
            if (destCity == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> neighborCities = graph.getOrDefault(destCity, new HashMap<>());
                for (int neighbor : neighborCities.keySet()) {
                    pq.add(new int[]{neighbor, price + neighborCities.get(neighbor), stops - 1});
                }
            }
        }

        return -1;
    }

    /**
     * Dijkstra’s shortest path algorithm
     *
     * @param n
     * @param graph
     * @param src
     * @return
     */
    public int[] findShortestPath(int n, int[][] graph, int src) {
        int[] distFromSrc = new int[n];
        boolean[] isFinished = new boolean[n];

        for (int i = 0; i < n; i++) {
            distFromSrc[i] = Integer.MAX_VALUE;
            isFinished[i] = false;
        }
        distFromSrc[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minVertex(distFromSrc, isFinished);
            isFinished[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !isFinished[v] && (distFromSrc[u] + graph[u][v] < distFromSrc[v])) {
                    distFromSrc[v] = distFromSrc[u] + graph[u][v];
                }
            }
        }

        return distFromSrc;
    }

    public int minVertex(int[] distFromSrc, boolean[] isFinished) {
        int minValue = Integer.MIN_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distFromSrc.length; i++) {
            if (!isFinished[i] && distFromSrc[i] <= minValue) {
                minValue = distFromSrc[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Youtube solution, DFS
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public static int findCheapestPrice_dfs(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] f : flights) {
            int s = f[0];
            int d = f[1];
            int price = f[2];
            graph[s][d] = price;
        }

        boolean[] visited = new boolean[n];
        visited[src] = true;
        int[] minPrice = new int[]{Integer.MAX_VALUE};
        Dfs(src, dst, K + 1, 0, visited, graph, minPrice);

        return minPrice[0] == Integer.MAX_VALUE ? -1 : minPrice[0];
    }

    public static void Dfs(int start, int end, int stops, int price, boolean[] visited, int[][] graph, int[] minPrice) {
        if (start == end) {
            minPrice[0] = price;
        }
        if (stops == 0) return;

        for (int v = 0; v < graph.length; v++) {
            if (graph[start][v] != 0 && !visited[v] && price + graph[start][v] < minPrice[0]) {
                visited[v] = true;
                Dfs(v, end, stops - 1, price + graph[start][v], visited, graph, minPrice);
                visited[v] = false;
            }
        }
    }

    /**
     * Youtube BFS solution
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public static int findCheapestPrice_bfs(int n, int[][] flights, int src, int dst, int K) {
        int k = K + 1;

        int[][] graph = new int[n][n];
        for (int[] f : flights) {
            int s = f[0];
            int d = f[1];
            int price = f[2];
            graph[s][d] = price;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0}); // src, price

        int minPrice = Integer.MAX_VALUE;

        while (!q.isEmpty() && k >= 0) { // k >= 0 is because we use 1 extra step to poll out the src node.
            int size = q.size();
            while (size > 0) {
                int[] city = q.poll();
                if (city[0] == dst) minPrice = Math.min(minPrice, city[1]);
                for (int v = 0; v < n; v++) {
                    if (graph[city[0]][v] != 0 && city[1] + graph[city[0]][v] < minPrice) {
                        q.add(new int[]{v, city[1] + graph[city[0]][v]});
                    }
                }
                size--;
            }
            if (--k == 0) break;
        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
}
