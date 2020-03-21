package asu.edu.arav.amazon.interview.dfs;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite {

    /**
     * @algo - DFS color algorithm
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */
    int[] color = null;
    int[][] graph;
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        color = new int[graph.length];
        this.graph = graph;
        for(int i = 0; i < color.length; i++){
            if(color[i] == 0) {
                color[i] = 1;
                if(!dfsCheck(i)) return false;
            }
        }
        return true;
    }

    public boolean dfsCheck(int nodeIdx){

        for(int child : graph[nodeIdx]){
            if(color[child] == color[nodeIdx]) return false;
            else if(color[child] == 0) {
                color[child] = color[nodeIdx] == 1 ? 2 : 1;
                if(!dfsCheck(child)) return false;
            }
        }
        return true;
    }


    public boolean isBipartite1(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        color = new int[graph.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < color.length; i++){
            if(color[i] == 0){
                color[i] = 1;
                st.push(i);
                while(!st.isEmpty()){
                    int nodeIdx = st.pop();
                    for(int child : graph[nodeIdx]){
                        if(color[child] == color[nodeIdx]) return false;
                        else if(color[child] == 0) {
                            color[child] = color[nodeIdx] == 1 ? 2 : 1;
                            st.push(child);
                        }
                    }
                }
            }
        }
        return true;
    }


}
