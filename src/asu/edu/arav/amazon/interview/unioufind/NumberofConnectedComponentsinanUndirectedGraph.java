package asu.edu.arav.amazon.interview.unioufind;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberofConnectedComponentsinanUndirectedGraph {

    /**
     *
     * @algo - Union Find
     * @time-complexity -
     * @space-complexity -
     */

    public int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            connected--;
            parent[px] = py;
        }
    }

    int [] parent = null;
    int connected = 0;
    public int countComponents(int n, int[][] edges) {
        if (n == 1) return n;
        parent = new int[n];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }
        return connected;
    }
}
