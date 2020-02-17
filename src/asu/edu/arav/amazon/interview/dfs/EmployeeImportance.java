package asu.edu.arav.amazon.interview.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @algo - DFS
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */

    Map<Integer, Employee> idToEmpMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }
        for(Employee emp : employees){
            idToEmpMap.put(emp.id, emp);
        }
        return returnImp(id);
    }

    public int returnImp(int id){
        Employee emp = idToEmpMap.get(id);
        int ans = emp.importance;
        for(int child : emp.subordinates){
            ans += returnImp(child);
        }
        return ans;
    }



}
