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
                int secondNode = i > 0? connection.get(i-1): connection.get(i+1);
                if (metaData.containsKey(connection.get(i))) {
                    if(metaData.get(connection.get(i)).containsKey(secondNode)){
                        HashMap<Integer, Integer> temp = metaData.get(connection.get(i));
                        int count = temp.get(secondNode);
                        temp.put(secondNode, ++count);
                        metaData.put(connection.get(i), temp);
                    }else{
                        HashMap<Integer, Integer> temp = metaData.get(connection.get(i));
                        temp.put(secondNode, 1);
                        metaData.put(connection.get(i), temp);
                    }
                } else {
                    HashMap<Integer, Integer> tempMap  = new HashMap<Integer, Integer>();
                    tempMap.put(secondNode, 1);
                    metaData.put(connection.get(i),tempMap);
                }
            }
            metaData = metaDataDependencyAddition(metaData, connection.get(0), connection.get(1));
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (List<Integer> connection : connections) {
            if(metaData.get(connection.get(0)).get(connection.get(1)) == 1){
                answer.add(connection);
            }
        }
        return answer;
    }

    public static HashMap<Integer, HashMap<Integer, Integer>> metaDataDependencyAddition(HashMap<Integer, HashMap<Integer, Integer>> metaData,
                                                                                  int nodeOne, int nodeTwo){
        if(metaData.containsKey(nodeTwo)){
            for(Integer node : metaData.get(nodeTwo).keySet()){
                if(node!= nodeOne){
                    int count = metaData.get(nodeOne).getOrDefault(node, 0);
                    metaData.get(nodeOne).put(node,++count);
                    if(metaData.containsKey(node)){
                        HashMap<Integer, Integer> tempMap = metaData.get(node);
                        count = tempMap.getOrDefault(nodeOne, 0);
                        tempMap.put(nodeOne, ++count);
                        metaData.put(node, tempMap);
                    }else{
                        HashMap<Integer, Integer> tempMap  = new HashMap<Integer, Integer>();
                        tempMap.put(nodeOne, 1);
                        metaData.put(node,tempMap);
                    }
                }
            }
        }if(metaData.containsKey(nodeOne)){
            for(Integer node : metaData.get(nodeOne).keySet()){
                if(node!= nodeTwo){
                    int count = metaData.get(nodeTwo).getOrDefault(node, 0);
                    metaData.get(nodeTwo).put(node,++count);
                    if(metaData.containsKey(node)){
                        HashMap<Integer, Integer> tempMap = metaData.get(node);
                        count = tempMap.getOrDefault(nodeTwo, 0);
                        tempMap.put(nodeTwo, ++count);
                        metaData.put(node, tempMap);
                    }else{
                        HashMap<Integer, Integer> tempMap  = new HashMap<Integer, Integer>();
                        tempMap.put(nodeTwo, 1);
                        metaData.put(node,tempMap);
                    }
                }
            }
        }
        return metaData;
    }

    public static void main(String[] args){
        List<List<Integer>> input = new ArrayList<>();


        List<Integer> one = new ArrayList<Integer>();
        one.add(0);
        one.add(1);

        input.add(one);

        one =new ArrayList<Integer>();
        one.add(1);
        one.add(2);

        input.add(one);

        one =new ArrayList<Integer>();
        one.add(2);
        one.add(0);

        input.add(one);


        one =new ArrayList<Integer>();
        one.add(1);
        one.add(3);

        input.add(one);
        System.out.println(criticalConnections(4, input));
    }

}
