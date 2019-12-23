package asu.edu.arav.amazon.interview.mst;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 */
public class ConnectingCitiesWithMinimumCost {

    int parent[] = null;
    int n = -1;

    // making two nodes get connected , by their parents to be common
    public void union(int x, int y) {
        int parentx = find(x);
        int parentY = find(y);
        parent[parentx] = parentY;
        n--;
    }

    // finding the lowest leveled parent
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // path expression
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // we will implement Krushkal Algorithm O(nlgn) n - number of edges
    public int minimumCost(int N, int[][] connections) {
        this.n = N;
        this.parent = new int[N + 1];
        for (int i = 0; i <= this.n; i++) {
            parent[i] = i;
        }

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int[] connection : connections) {
            int v1 = connection[0];
            int v2 = connection[1];
            if (find(v1) != find(v2)) {
                cost += connection[2];
                union(v1, v2);
            }
        }

        return n == 1 ? cost : -1;
    }


}
