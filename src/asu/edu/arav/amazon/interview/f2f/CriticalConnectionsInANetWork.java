package asu.edu.arav.amazon.interview.f2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CriticalConnectionsInANetWork {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, HashMap<Integer, Integer>> metaData = new HashMap<Integer, HashMap<Integer, Integer>>();

        for (List<Integer> connection : connections) {
            for (int i = 0; i < connection.size(); i++) {
                int secondNode = i > 0 ? connection.get(i - 1) : connection.get(i + 1);
                if (metaData.containsKey(connection.get(i))) {
                    if (metaData.get(connection.get(i)).containsKey(secondNode)) {
                        HashMap<Integer, Integer> temp = metaData.get(connection.get(i));
                        int count = temp.get(secondNode);
                        temp.put(secondNode, ++count);
                        metaData.put(connection.get(i), temp);
                    } else {
                        HashMap<Integer, Integer> temp = metaData.get(connection.get(i));
                        temp.put(secondNode, 1);
                        metaData.put(connection.get(i), temp);
                    }
                } else {
                    HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
                    tempMap.put(secondNode, 1);
                    metaData.put(connection.get(i), tempMap);
                }
            }
            metaData = metaDataDependencyAddition(metaData, connection.get(0), connection.get(1));
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (List<Integer> connection : connections) {
            if (metaData.get(connection.get(0)).get(connection.get(1)) == 1) {
                answer.add(connection);
            }
        }
        return answer;
    }

    public static HashMap<Integer, HashMap<Integer, Integer>> metaDataDependencyAddition(HashMap<Integer, HashMap<Integer, Integer>> metaData,
                                                                                         int nodeOne, int nodeTwo) {
        if (metaData.containsKey(nodeTwo)) {
            for (Integer node : metaData.get(nodeTwo).keySet()) {
                if (node != nodeOne) {
                    int count = metaData.get(nodeOne).getOrDefault(node, 0);
                    metaData.get(nodeOne).put(node, ++count);
                    if (metaData.containsKey(node)) {
                        HashMap<Integer, Integer> tempMap = metaData.get(node);
                        count = tempMap.getOrDefault(nodeOne, 0);
                        tempMap.put(nodeOne, ++count);
                        metaData.put(node, tempMap);
                    } else {
                        HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
                        tempMap.put(nodeOne, 1);
                        metaData.put(node, tempMap);
                    }
                }
            }
        }
        if (metaData.containsKey(nodeOne)) {
            for (Integer node : metaData.get(nodeOne).keySet()) {
                if (node != nodeTwo) {
                    int count = metaData.get(nodeTwo).getOrDefault(node, 0);
                    metaData.get(nodeTwo).put(node, ++count);
                    if (metaData.containsKey(node)) {
                        HashMap<Integer, Integer> tempMap = metaData.get(node);
                        count = tempMap.getOrDefault(nodeTwo, 0);
                        tempMap.put(nodeTwo, ++count);
                        metaData.put(node, tempMap);
                    } else {
                        HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
                        tempMap.put(nodeTwo, 1);
                        metaData.put(node, tempMap);
                    }
                }
            }
        }
        return metaData;
    }

    public int id = 0;
    public int[] discoveredWhen;
    public int[] lowestParentTheNodeHasConnection;
    List<Integer>[] graph;

    public void dfsToFindBridge(int nodeToVisit, int parentNodeId, List<List<Integer>> bridges) {
        discoveredWhen[nodeToVisit] = ++id;
        lowestParentTheNodeHasConnection[nodeToVisit] = ++id;
        for(int child : graph[nodeToVisit]){
            if(child == parentNodeId){
                continue;
            }else if(discoveredWhen[child] == 0){
                dfsToFindBridge(child, nodeToVisit, bridges);
                lowestParentTheNodeHasConnection[nodeToVisit] = Math.min(lowestParentTheNodeHasConnection[nodeToVisit],
                        lowestParentTheNodeHasConnection[child]);
                if(discoveredWhen[nodeToVisit] < lowestParentTheNodeHasConnection[child]){
                    List<Integer> bridge = new ArrayList<Integer>();
                    bridge.add(nodeToVisit);
                    bridge.add(child);
                    bridges.add(bridge);
                }
            }else {
                lowestParentTheNodeHasConnection[nodeToVisit] = Math.min(lowestParentTheNodeHasConnection[nodeToVisit],
                        lowestParentTheNodeHasConnection[child]);
            }
        }
    }

    public void buildTheGraph(List<Integer>[] graph, List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            if(graph[connection.get(0)] == null){
                graph[connection.get(0)] = new ArrayList<Integer>();
            }
            if(graph[connection.get(1)] == null){
                graph[connection.get(1)] = new ArrayList<Integer>();
            }
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
    }

    public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<List<Integer>>();
        graph = new ArrayList[n + 1];
        buildTheGraph(graph, connections);
        discoveredWhen = new int[n + 1];
        lowestParentTheNodeHasConnection = new int[n + 1];
        dfsToFindBridge(1, -1, bridges);
        return bridges;
    }

    public void bluidGraph(List<List<Integer>> connections) {


    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();


        List<Integer> one = new ArrayList<Integer>();
        one.add(0);
        one.add(1);

        input.add(one);

        one = new ArrayList<Integer>();
        one.add(1);
        one.add(2);

        input.add(one);

        one = new ArrayList<Integer>();
        one.add(2);
        one.add(0);

        input.add(one);


        one = new ArrayList<Integer>();
        one.add(1);
        one.add(3);

        input.add(one);
        System.out.println(criticalConnections(4, input));
    }

}
