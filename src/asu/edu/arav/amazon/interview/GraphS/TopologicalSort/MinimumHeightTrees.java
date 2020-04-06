package asu.edu.arav.amazon.interview.GraphS.TopologicalSort;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ansList = new ArrayList<>();

        if (n == 1) {
            ansList.add(0);
            return ansList;
        }

        HashMap<Integer, List<Integer>> verticeToEgdesMap = new HashMap<>();
        HashMap<Integer, Integer> verticeToDegreeMap = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> list0 = verticeToEgdesMap.getOrDefault(edge[0], new ArrayList<Integer>());
            List<Integer> list1 = verticeToEgdesMap.getOrDefault(edge[1], new ArrayList<Integer>());
            list0.add(edge[1]);
            list1.add(edge[0]);
            verticeToEgdesMap.put(edge[0], list0);
            verticeToEgdesMap.put(edge[1], list1);
            verticeToDegreeMap.put(edge[0], verticeToDegreeMap.getOrDefault(edge[0], 0) + 1);
            verticeToDegreeMap.put(edge[1], verticeToDegreeMap.getOrDefault(edge[1], 0) + 1);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int vertice : verticeToDegreeMap.keySet()) {
            if (verticeToDegreeMap.get(vertice) == 1) {
                queue.offer(vertice);
            }
        }

        while (!queue.isEmpty()) {
            ansList.clear();
            int levelSize = queue.size();
            for(int i =0 ; i < levelSize; i++){
                int node  = queue.poll();
                ansList.add(node);
                verticeToDegreeMap.put(node, verticeToDegreeMap.getOrDefault(node, 0) - 1);
                for(int child : verticeToEgdesMap.get(node)){
                    verticeToDegreeMap.put(child, verticeToDegreeMap.getOrDefault(child, 0) - 1);
                    if(verticeToDegreeMap.get(child) == 1){
                        queue.offer(child);
                    }
                }
            }
        }

        return ansList;
    }
}
