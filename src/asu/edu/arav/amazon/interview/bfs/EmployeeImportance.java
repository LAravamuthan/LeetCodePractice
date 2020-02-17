package asu.edu.arav.amazon.interview.bfs;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    /**
     * @algo - BFS
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */
    Map<Integer, Integer> idToImpMap = new HashMap<>();
    Map<Integer, Set<Integer>> idToChildMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        for (Employee em : employees) {
            idToImpMap.put(em.id, em.importance);
            idToChildMap.put(em.id, new HashSet<Integer>(em.subordinates));
        }
        int imp = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        imp += idToImpMap.get(id);
        while(!queue.isEmpty()){
            int pId = queue.poll();
            for(int child : idToChildMap.get(pId)){
                queue.add(child);
                imp += idToImpMap.get(child);
            }
        }
        return imp;
    }
}
