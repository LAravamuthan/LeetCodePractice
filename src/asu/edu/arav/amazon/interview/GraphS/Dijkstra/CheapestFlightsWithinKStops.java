package asu.edu.arav.amazon.interview.GraphS.Dijkstra;

import java.security.spec.ECGenParameterSpec;
import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

    /**
     * @algo - Dijkstra
     * @time-complexity - O(E + nlogn)
     * @space-complexity - O(n)
     */
    class Edge {
        int weight = 0;
        int node = 0;
        int stops = 0;

        public Edge(int node, int weight) {
            this.weight = weight;
            this.node = node;
        }

        public Edge(int node, int weight, int stops) {
            this.weight = weight;
            this.node = node;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            Edge e = new Edge(flights[i][1], flights[i][2]);
            List<Edge> egdes = graph.getOrDefault(s, new ArrayList<>());
            egdes.add(e);
            graph.put(s, egdes);
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        Map<Integer, Integer> stopPlaceCost = new HashMap<>();
        pq.offer(new Edge(src, 0, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (e.stops > K + 1 || e.weight > stopPlaceCost.getOrDefault(e.stops * 1000 + e.node,
                    Integer.MAX_VALUE)) continue;
            if (e.node == dst) return e.weight;
            for (Edge child : graph.getOrDefault(e.node, new ArrayList<>())) {
                int newCost = child.weight + e.weight;
                if (newCost < stopPlaceCost.getOrDefault((e.stops + 1) * 1000 + child.node,
                        Integer.MAX_VALUE)) {
                    pq.offer(new Edge(child.node, newCost, e.stops + 1));
                    stopPlaceCost.put((e.stops + 1) * 1000 + child.node, newCost);
                }

            }
        }
        return -1;
    }

    /**
     * @algo - DP and optimised
     * @time-complexity - O(E * K)
     * @space-complexity - O(n)
     */

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        /* you just need the next previous sate from the current state
         * if 0 th index array stores current values then
         * 1th index array stores the previous values for dist */
        int[][] dist = new int[2][n];
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);
        dist[0][src] = 0;
        dist[1][src] = 0;
        for (int i = 0; i <= K; i++) {
            for (int[] flight : flights) {
                dist[i % 2][flight[1]] = Math.min(dist[i % 2][flight[1]], flight[2]
                        + dist[(i + 1) % 2][flight[0]]);
            }
        }

        return dist[K % 2][dst] == Integer.MAX_VALUE ? -1 : dist[K % 2][dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        c.findCheapestPrice(3, flights, 0, 2, 1);
    }
}
