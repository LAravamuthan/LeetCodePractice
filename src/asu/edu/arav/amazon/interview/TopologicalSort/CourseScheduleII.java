package asu.edu.arav.amazon.interview.TopologicalSort;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> verticeToEdgesMap = new HashMap<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegreeMap.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            List childs = verticeToEdgesMap.getOrDefault(prerequisite[1], new ArrayList<>());
            childs.add(prerequisite[0]);
            verticeToEdgesMap.put(prerequisite[1], childs);
            inDegreeMap.put(prerequisite[0], inDegreeMap.get(prerequisite[0]) + 1);
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int course : inDegreeMap.keySet()) {
            if (inDegreeMap.get(course) == 0) {
                queue.offer(course);
            }
        }
        List<Integer> orderOfcourses = new ArrayList<>();

        while (!queue.isEmpty()) {
            int course = queue.poll();
            orderOfcourses.add(course);
            for (int child : verticeToEdgesMap.getOrDefault(course, new ArrayList<>())) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                if (inDegreeMap.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        int[] ans = new int[0];
        if (orderOfcourses.size() == numCourses) {
            ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = orderOfcourses.get(i);
            }
        }

        return ans;
    }
}
