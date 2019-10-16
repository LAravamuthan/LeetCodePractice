package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CourseSchedule {

    boolean[] visitedCoures;
    boolean[] isCurrentAncester;
    Map<Integer, List<Integer>> courseToPrerequisiteMapping = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || numCourses < 2) {
            return true;
        }

        visitedCoures = new boolean[numCourses];
        isCurrentAncester = new boolean[numCourses];

        // build graph as a HashMap with nodes as key and connected nodes as List of Integer
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = courseToPrerequisiteMapping.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            list.add(prerequisites[i][1]);
            courseToPrerequisiteMapping.put(prerequisites[i][0], list);
            //putting one entry as node as the start and finish as its child
            // another entry will finish as key if its not avaiable in the map yet
            list = courseToPrerequisiteMapping.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            courseToPrerequisiteMapping.put(prerequisites[i][1], list);
        }

        for(int key : courseToPrerequisiteMapping.keySet()){

            // run for all the courses in case there are disconnected components we need
            // to make sure that the dfs is run from all the root of connected components
            if(dfsUtilRecutsive(key)){
                continue;
            }
            return false;
        }
        return true;
    }

    // recursion util for doing dfs search on one course node and sebsequent childs of it
    public boolean dfsUtilRecutsive(int node){

        // It current node was already seen as part of this dfs search
        if(isCurrentAncester[node]){
            return false;
        }

        // if the current node was already seen as part annoter disconnted component then from here we wont
        // see cycle any more;
        if(visitedCoures[node]){
            return true;
        }
        // marking current node visted and also current part the dfs searching
        visitedCoures[node] = true;
        isCurrentAncester[node] = true;

        for(int childNodes : courseToPrerequisiteMapping.get(node)){
            // recursively test the child nodes for cycles if all the childs are cool then return positive
            // result for no cycle
            if(dfsUtilRecutsive((childNodes))){
                continue;
            }
            return false;
        }
        isCurrentAncester[node] = false; // tree rooted at current node has been tested we mark it not part of the
        // dfs recursive stack, but marked visited - this fact is very important remember that
        return true;
    }
}
