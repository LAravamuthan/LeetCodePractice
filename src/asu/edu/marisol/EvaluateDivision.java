package asu.edu.marisol;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class EvaluateDivision {

    /**
     * Important Union-find method.
     *
     * TODO: revise this for sure, understand the tweaks here.
     *
     * @time-complexity - O ((N + M) logN).
     * @space-complexity - O (N).
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Pair<String, Double>> groupIDWeight = new HashMap<>();
        double[] result = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0), divisor = equations.get(i).get(1);
            double value = values[i];

            union(groupIDWeight, dividend, divisor, value);
        }

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0), divisor = queries.get(i).get(1);

            if (!groupIDWeight.containsKey(dividend) || !groupIDWeight.containsKey(divisor)) {
                result[i] = -1.0;
                continue;
            }

            Pair<String, Double> dividendPair = find(dividend, groupIDWeight);
            Pair<String, Double> divisorPair = find(divisor, groupIDWeight);

            if (!dividendPair.getKey().equals(divisorPair.getKey()))
                result[i] = -1.0;
            else {
                result[i] = dividendPair.getValue() / divisorPair.getValue();
            }
        }

        return result;
    }


    private Pair<String, Double> find(String nodeId, Map<String, Pair<String, Double>> groupIDWeight) {
        if (!groupIDWeight.containsKey(nodeId))
            groupIDWeight.put(nodeId, new Pair<>(nodeId, 1.0));

        Pair<String, Double> pair = groupIDWeight.get(nodeId);
        if (!pair.getKey().equals(nodeId)) {
            Pair<String, Double> newPair = find(pair.getKey(), groupIDWeight);
            groupIDWeight.put(nodeId, new Pair<>(newPair.getKey(), newPair.getValue() * pair.getValue()));
        }

        return groupIDWeight.get(nodeId);
    }

    private void union(Map<String, Pair<String, Double>> groupIDWeight, String dividend, String divisor, double value) {
        Pair<String, Double> dividendPair = find(dividend, groupIDWeight);
        Pair<String, Double> divisorPair = find(divisor, groupIDWeight);

        String dividendGid = dividendPair.getKey();
        String divisorGid = divisorPair.getKey();
        double dividendWeight = dividendPair.getValue();
        double divisorWeight = divisorPair.getValue();

        if (!dividendGid.equals(divisorGid))
            groupIDWeight.put(dividendGid, new Pair<>(divisorGid, divisorWeight * value / dividendWeight));

    }


    /**
     * DFS method.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (N).
     */
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> weightedMap = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0), divisor = equations.get(i).get(1);
            double value = values[i];

            weightedMap.computeIfAbsent(dividend, k-> new HashMap<>()).put(divisor, value);
            weightedMap.computeIfAbsent(divisor, k-> new HashMap<>()).put(dividend, 1 / value);

        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0), divisor = queries.get(i).get(1);

            if (!weightedMap.containsKey(dividend) || !weightedMap.containsKey(divisor)) {
                result[i] = -1; continue;
            }

            result[i] = dfsCalculation(dividend, divisor, 1.0, weightedMap, new HashSet<>());
        }

        return result;
    }

    private double dfsCalculation(String curNode, String targetNode, double value,
                                  Map<String, Map<String, Double>> weightedMap, Set<String> visited) {
        if (curNode.equals(targetNode)) return value;
        visited.add(curNode);

        double result = -1.0;

        for (String neighbor : weightedMap.get(curNode).keySet()) {
            if (visited.contains(neighbor)) continue;
            result = dfsCalculation(neighbor, targetNode, value * weightedMap.get(curNode).get(neighbor), weightedMap, visited);
            if (result != -1.0) break;
        }

        visited.remove(curNode);
        return result;
    }

}
