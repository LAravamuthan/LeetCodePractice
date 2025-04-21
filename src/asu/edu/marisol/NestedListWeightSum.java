package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NestedListWeightSum {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * DFS approach.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfsSum(nestedList, 1);
    }

    private int dfsSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                sum += element.getInteger() * depth;
            } else {
                sum += dfsSum(element.getList(), depth + 1);
            }
        }
        return sum;
    }

    /**
     * BFS approach.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public int depthSum2(List<NestedInteger> nestedList) {
        int sum = 0;

        Queue<Pair<List<NestedInteger>, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(nestedList, 1));

        while (!queue.isEmpty()) {
            Pair<List<NestedInteger>, Integer> element = queue.poll();
            List<NestedInteger> list = element.getKey();
            int depth = element.getValue();

            for (NestedInteger nt : list) {
                if (nt.isInteger()) sum += nt.getInteger() * depth;
                else queue.offer(new Pair<>(nt.getList(), depth + 1));
            }
        }

        return sum;
    }

}
